package com.compi1.nodepad.src.text_output;

public class SizeText extends  Paragraph {

    public static final int H1 = 26;
    public static final int H2 = 24;
    public static final int H3 = 22;
    public static final int H4 = 20;
    public static final int H5 = 18;
    public static final int H6 = 16;

    private int size;

    public SizeText(String body, int size){
        super(body);
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}