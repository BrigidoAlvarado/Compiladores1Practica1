package com.compi1.nodepad.src.text_output;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberedList extends TextList{

    private final List<Integer> itemNumbers = new ArrayList<Integer>();
    private String firstItem;

    public NumberedList( String item, String numberedItem ){
        super(new ArrayList<String>(Arrays.asList(item)));
        itemNumbers.add( getNumberItem( numberedItem ) );
    }

    public void setItems(String numberedItem, String item){
        itemNumbers.add( getNumberItem(numberedItem) );
        items.add(item);
    }

    public List<Integer> getItemNumbers() {
        return itemNumbers;
    }

    public String getFirstItem() {
        return firstItem;
    }

    private int getNumberItem( String numberedItem){
        return Integer.parseInt( numberedItem.substring( 0, numberedItem.length() - 2) );
    }
}
