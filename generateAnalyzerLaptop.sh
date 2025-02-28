#!/bin/bash
JFLEX="/home/brigidoalvarado/Escritorio/Compiladores1Practica1/Nodepad/app/src/main/java/com/compi1/nodepad/scannerFiles/lexer/Text-lexer.flex"
CUP="/home/brigidoalvarado/Escritorio/Compiladores1Practica1/Nodepad/app/src/main/java/com/compi1/nodepad/scannerFiles/parser/text-parser.cup"

JARCUP="/home/brigidoalvarado/Documentos/java-cup-bin-11b-20160615/java-cup-11b.jar"
DESTINY_CUP="/home/brigidoalvarado/Escritorio/Compiladores1Practica1/Nodepad/app/src/main/java/com/compi1/nodepad/scannerFiles/parser"

# Generar analizador léxico con JFlex
jflex "$JFLEX"

# Generar analizador sintáctico con CUP
java -jar "$JARCUP" -destdir "$DESTINY_CUP"  -parser Parser -symbols sym  "$CUP"

echo "Compilación completada. Archivos generados"

