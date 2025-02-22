package com.compi1.nodepad.scannerFiles.lexer

import java_cup.runtime.*;
//importacion de la clase sym
%%

%class textLexer
%cup
%public
%line
%column

//codigo java

%{
private Symbol symbol(int type){
    return new Symbol(type, yyline + 1, yycolumn + 1);
}

private Symbol symbol(int type, Object value){
    return new Symbol(type, yyline + 1, yycolumn + 1, value);
}

%}

LineTerminator = \r|\n|\r\n
WhiteSpace = \h
Word = [a-bA-B]+
Number = [0-9]+
Space = [ ]

%%
"#"{Space}       =  { return symbol(sym.H1, yytext()); }
"##"{Space}      =  { return symbol(sym.H2, yytext()); }
"###"{Space}     =  { return symbol(sym.H3, yytext()); }
"####"{Space}    =  { return symbol(sym.H4, yytext()); }
"#####"{Space}   =  { return Symbol(sym.H5, yytext()); }
"######"{Space}  =  { return Symbol(sym.H6, yytext()); }

//Lectura de parrafos
(.\n?)+          = { return Symbol(sym.PARAGRAPH yytext())}