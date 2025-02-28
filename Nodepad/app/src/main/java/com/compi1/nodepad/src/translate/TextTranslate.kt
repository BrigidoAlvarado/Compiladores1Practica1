package com.compi1.nodepad.src.translate

import android.text.SpannableString
import android.text.SpannableStringBuilder
import com.compi1.nodepad.scannerFiles.lexer.TextLexer
import com.compi1.nodepad.scannerFiles.parser.Parser
import com.compi1.nodepad.src.text_output.Paragraph
import com.compi1.nodepad.src.text_output.SizeText
import com.compi1.nodepad.src.text_output.StyleText
import com.compi1.nodepad.src.text_output.TextList
import com.compi1.nodepad.src.text_output.TextSyntacOutput
import java.io.StringReader

class TextTranslate {

    fun  translate(input: String): SpannableStringBuilder {

        val reader  = StringReader(input)
        val lexer   = TextLexer(reader)
        val parser  = Parser(lexer)

        parser.parse()
        val syntacticData = parser.data

        return formatter(syntacticData)
    }

    private fun formatter( syntacticData: List <TextSyntacOutput> ): SpannableStringBuilder{

        lateinit var spannable: SpannableString;

        val textBuild = SpannableStringBuilder()
        val formatter = Formatter()

        for (syntacticOutput in syntacticData){

            when (syntacticOutput) {
                is SizeText -> {
                    spannable = formatter.size(syntacticOutput.body, syntacticOutput.size)
                }
                is StyleText -> {
                    spannable = formatter.style(syntacticOutput.body, syntacticOutput.type)
                }
                is Paragraph -> {
                    spannable = formatter.size(syntacticOutput.body, SizeText.TEXT)
                }
                is TextList -> {
                    spannable = formatter.list(syntacticOutput.items)
                }
            }
            textBuild.append(spannable)
        }
        return textBuild
    }
}