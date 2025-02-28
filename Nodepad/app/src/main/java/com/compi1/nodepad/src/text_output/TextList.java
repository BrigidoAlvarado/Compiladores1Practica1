package com.compi1.nodepad.src.text_output;

import java.util.List;

public class TextList extends TextSyntacOutput{

    protected List<String> items;

    public TextList(List<String> items){
        this.items = items;
        setLineBreak();
    }

    public List<String> getItems(){
        return items;
    }

    private void setLineBreak(){
        for (String item: items) {
            if (!item.endsWith("\n")){
                item += "\n";
            }
        }
    }
}