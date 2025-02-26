#!/bin/bash

JFLEX="/home/brigido/Escritorio/Practica1Compiladores1/Nodepad/app/src/main/java/com/compi1/nodepad/scannerFiles/lexer/Text-lexer.flex"
CUP="/home/brigido/Escritorio/Practica1Compiladores1/Nodepad/app/src/main/java/com/compi1/nodepad/scannerFiles/parser/text-parser.cup"

JARCUP="/home/brigido/Documentos/java-cup-bin-11b-20160615/java-cup-11b.jar"

# Generar analizador léxico con JFlex
jflex "$JFLEX"

# Generar analizador sintáctico con CUP
java -jar "$JARCUP"  -parser Parser -symbols sym  "$CUP"

echo "Compilación completada. Archivos generados"
