package com.compi1.nodepad.src.text_output;

public class StyleText extends Paragraph {

    private FormatType type;

    public StyleText(String body, FormatType type){
        super((body));
        this.type = type;
    }

    public FormatType getType() {
        return type;
    }

    public void setType(FormatType type) {
        this.type = type;
    }
}
