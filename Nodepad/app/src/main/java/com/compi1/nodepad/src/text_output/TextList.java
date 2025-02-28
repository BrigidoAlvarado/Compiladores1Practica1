package com.compi1.nodepad.src.text_output;

import java.util.ArrayList;
import java.util.List;

public class TextList extends TextSyntacOutput{

    private final List<String> items;


    
    public TextList(List<String> items){
        this.items = items;
        setLineBreak();
    }

    public List<String> getItems(){
        return items;
    }

    protected void setLineBreak(){
        for (String item: items) {
            if (!item.endsWith("\n")){
                item += "\n";
            }
        }
    }

    public String[] hola(){

        return new String[]{"hola"} ;
    }
}