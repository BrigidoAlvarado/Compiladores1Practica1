package com.compi1.nodepad.scannerFiles.lexer;

import java_cup.runtime.*;
import com.compi1.nodepad.scannerFiles.parser.sym;

%%

%class TextLexer
%cup
%public
%line
%column
%debug
%unicode

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
Word            = [a-zA-Z]+
Number          = [0-9]+
PunctuationMarks= ("."|","|"?"|"¿"|"¡"|"!"!":"|";")
Alphanumeric    = ({Word}|{Number})+
Sentence        = [^"\*"][^0-9]({Alphanumeric}|{Space}|{PunctuationMarks})+{LineTerminator}?
%%
//Marcadores para las cabeceras
"#"{Space}              { return symbol(sym.H1, yytext()); }
"##"{Space}             { return symbol(sym.H2, yytext()); }
"###"{Space}            { return symbol(sym.H3, yytext()); }
"####"{Space}           { return symbol(sym.H4, yytext()); }
"#####"{Space}          { return symbol(sym.H5, yytext()); }
"######"{Space}         { return symbol(sym.H6, yytext()); }


//Lecutra de los marcadores para el tipo de formato de los textos
"\*"                    { return symbol(sym.ITALIC, yytext()); }
\*\*                    { return symbol(sym.BOLD, yytext()); }
\*\*\*                  { return symbol(sym.ITALIC_BOLD, yytext()); }


//Lecutra de los marcadores para las listas enumeradas
"1."{Space}             { return symbol(sym.INIT_LIST,  yytext()); }
[2-9][1-9]*.{Space}     { return symbol(sym.ITEM_NUM, yytext()); }


//Lecutra de los marcadores para las listas de texto no numeradas
\+{Space}               { return symbol(sym.ITEM_LIST, yytext()); }


//Lecuta de textos alfanumericos con espacios que pueden o no terminar con un salto de linea
{Sentence}              { return symbol(sym.SENTENCE, yytext()); }

{LineTerminator}        { return symbol(sym.BREAKLINE, yytext()); }         

//Lectura de Errores
[^]                     { return symbol(sym.error, yytext()); }

//Fin del archivo
<<EOF>>                 { return symbol(sym.EOF);   }