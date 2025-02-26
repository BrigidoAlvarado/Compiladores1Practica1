package com.compi1.nodepad.src.text_output;

public class Paragraph extends TextSyntacOutput {

    protected String body;

    public Paragraph (String body){
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}