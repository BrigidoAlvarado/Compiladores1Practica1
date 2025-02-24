package com.compi1.nodepad.scannerFiles.lexer

import java_cup.runtime.*;
//importacion de la clase sym
%%

%class textLexer
%cup
%public
%line
%column
%debug

//codigo java

%{
private Symbol symbol(int type){
    return new Symbol(type, yyline + 1, yycolumn + 1);
}

private Symbol symbol(int type, Object value){
    return new Symbol(type, yyline + 1, yycolumn + 1, value);
}

%}

//quizas no sean de utilidad
EmptyLine       = \s*\n

LineTerminator  = \r|\n|\r\n
Space           = " "
Word            = [a-bA-B]+
Number          = [0-9]+
Alphanumeric    = ({Word}|{Number})+
Sentence        = ({Alphanumeric}|{Space}).+{LineTerminator}?

%%
//Marcadores para las cabeceras
"#"{Space}              { return symbol(sym.H1, yytext()); }
"##"{Space}             { return symbol(sym.H2, yytext()); }
"###"{Space}            { return symbol(sym.H3, yytext()); }
"####"{Space}           { return symbol(sym.H4, yytext()); }
"#####"{Space}          { return Symbol(sym.H5, yytext()); }
"######"{Space}         { return Symbol(sym.H6, yytext()); }


//Lecutra de los marcadores para el tipo de formato de los textos
\*                      { return Symbol(sym.ITALIC, yytext()); }
\*\*                    { return Symbol(sym.BOLD, yytext()); }
\*\*\*                  { return Symbol(sym.ITALIC_BOLD, yytext()); }


//Lecutra de los marcadores para las listas enumeradas
"1."{Space}             { return Symbol(sym.INIT_LIST,  yytext()); }
[2-9][1-9]*.{Space}     { return Symbol(sym.ORDER_LIST, yytext()); }


//Lecutra de los marcadores para las listas de texto no numeradas
\+{Space}               { return Symbol(sym.LIST_MARKER, yytext()); }


//Lecuta de textos alfanumericos con espacios que pueden o no terminar con un salto de linea
{Sentence}                  { return Symbol(sym.SENTENCE, yytext()); }


//Lectura de Errores
[^]                     { return Symbol(sym.error); }


//Fin del archivo
<<EOF>>                 { return Symbol(sym.EOF);   }
