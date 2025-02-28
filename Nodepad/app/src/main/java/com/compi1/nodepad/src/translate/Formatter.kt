package com.compi1.nodepad.src.translate

import android.graphics.Typeface
import android.text.SpannableString
import android.text.Spanned
import android.text.style.RelativeSizeSpan
import android.text.style.StyleSpan
import com.compi1.nodepad.src.text_output.FormatType
import com.compi1.nodepad.src.text_output.SizeText

class Formatter {

    fun style (body: String, type: FormatType): SpannableString{
        val style = SpannableString(body)

        when(type){
            FormatType.bold -> {
                setBoldFormat(style)
            }
            FormatType.italic -> {
                setItalicFormat(style)
            }
            FormatType.italicBold -> {
                setItalicBoldFormat(style)
            }
        }
        style.setSpan(RelativeSizeSpan(SizeText.TEXT), 0, style.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        return style
    }

    fun size ( body:String, size: Float ): SpannableString{

        //Spanble que representa el titulo con su formato
        val tittle = SpannableString(body)

        //Formateo del titulo
        tittle.setSpan(
            RelativeSizeSpan(size),
            0,
            tittle.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        return tittle
    }

    fun list(text: String){

    }

    private fun setBoldFormat(span:SpannableString){
        span.setSpan(StyleSpan(Typeface.BOLD), 0, span.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
    }

    private fun setItalicFormat(span: SpannableString){
        span.setSpan(StyleSpan(Typeface.ITALIC), 0, span.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
    }

    private fun setItalicBoldFormat( span: SpannableString){
        span.setSpan(StyleSpan(Typeface.BOLD_ITALIC), 0, span.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
    }
}