package com.compi1.nodepad.src.text_output;

import androidx.compose.foundation.lazy.LazyItemScope;

import java.util.List;

public class TextSyntacOutput {
    /* La utilidad de esta clase es poder agrupar los distintos objetos que
    *  representan las salidas sintacticas del parser de cup en una lista*/

    private List<TextSyntacOutput> data ;

    public void hola (){
        data.add(new SizeText());
    }
}
