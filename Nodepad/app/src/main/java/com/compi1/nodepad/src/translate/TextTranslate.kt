package com.compi1.nodepad.src.translate

import android.text.SpannableStringBuilder
import android.util.Log
import com.compi1.nodepad.scannerFiles.lexer.TextLexer
import com.compi1.nodepad.scannerFiles.parser.Parser
import com.compi1.nodepad.src.text_output.SizeText
import com.compi1.nodepad.src.text_output.TextSyntacOutput
import java.io.StringReader

class TextTranslate {

   public fun  translate(input: String): SpannableStringBuilder {

        val reader  = StringReader(input)
        val lexer   = TextLexer(reader)
        val parser  = Parser(lexer)

        parser.parse()
        val syntacticData = parser.data

        return formatter(syntacticData)
    }

    private fun formatter( syntacticData: List <TextSyntacOutput> ): SpannableStringBuilder{

        val textBuild = SpannableStringBuilder()
        val formatter = Formatter()

        for (syntacticOutput in syntacticData){
            if ( syntacticOutput is SizeText){
                val spannable = formatter.size(syntacticOutput)
                textBuild.append(spannable)
            }
        }
        return textBuild
    }
}