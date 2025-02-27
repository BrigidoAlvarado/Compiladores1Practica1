package com.compi1.nodepad.src.text_output;

import java.util.ArrayList;
import java.util.List;

public class SizeText extends  Paragraph {

    public static final float H1 = 3;
    public static final float H2 = 2.75F;
    public static final float H3 = 2.50F;
    public static final float H4 = 2.25F;
    public static final float H5 = 2;
    public static final float H6 = 1.80F;

    private float size;

    public SizeText(String body, float size){
        super(body);
        this.size = size;
    }

    public float getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}