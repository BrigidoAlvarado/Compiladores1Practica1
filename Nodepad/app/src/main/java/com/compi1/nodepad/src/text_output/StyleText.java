package com.compi1.nodepad.src.text_output;

public class StyleText extends Paragraph {

    private final FormatType type;

    public StyleText(String body, FormatType type){
        super((body));
        this.type = type;
    }

    public FormatType getType() {
        return type;
    }
}
