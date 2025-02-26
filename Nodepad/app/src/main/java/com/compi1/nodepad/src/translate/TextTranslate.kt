package com.compi1.nodepad.src.translate

import android.text.SpannableStringBuilder
import com.compi1.nodepad.scannerFiles.lexer.TextLexer
import com.compi1.nodepad.scannerFiles.parser.Parser
import java.io.StringReader

class TextTranslate {

    fun  translate(input: String): SpannableStringBuilder {

        val reader  = StringReader(input)
        val lexer   = TextLexer(reader)
        val parser  = Parser(lexer)

        parser.parse()
        return SpannableStringBuilder();
    }
}