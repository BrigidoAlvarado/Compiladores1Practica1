package com.compi1.nodepad.src.text_output;

public class LexerError extends  Paragraph{

    public LexerError(String body){
        super(" Token no reconocido: "+body);
    }
}
