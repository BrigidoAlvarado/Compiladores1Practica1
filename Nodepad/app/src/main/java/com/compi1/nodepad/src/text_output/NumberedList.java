package com.compi1.nodepad.src.text_output;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class NumberedList extends TextSyntacOutput{

    private final List<String[]> items;
    private final String firstItem;

    public NumberedList( String firstItem, List<String[]> items ){
        this.firstItem = firstItem;
        this.items = items;

        // primero hay que obtener los numeros de las listas
        cleanList(items);
        // despues hay que ordenarlos de menor a mayor
        items.sort(Comparator.comparing( num -> num[0]));
        // agregar salto de linea sin no lo tiene
        addBreakLine();
    }

    public List<String[]> getItems() {
        return items;
    }

    public String getFirstItem() {
        return firstItem;
    }

    // ELIMINA LOS DOS ULTIMOS CARACTERES DEL MARCADOR DE LISTA OSEA EL PUNTO Y EL ESPACIO
    // PARA DEJAR SOLO AL NUMERO Y PODER ORDENARLO DESPUES
    private String getNumberItem( String numberedItem){
        return ( numberedItem.substring( 0, numberedItem.length() - 2) );
    }

    //ELIMINA LOS DOS ULTIMOS CARACTERES DE TODA LA LISTA
    private void cleanList( List<String[]> list){
        for (String[] pair: list) {
            pair[0] = getNumberItem(pair[0]);
        }
    }

    //AGREGA UN SALTO DE LINEA AL FINAL DEL ITEM SI NO LO TIENE
    private void addBreakLine(){
        for (String[] item: items) {
            if (!item[1].endsWith("\n")){
                item[1] += "\n";
            }
        }
    }
}
