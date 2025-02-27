package com.compi1.nodepad.src.translate

import android.text.SpannableString
import android.text.Spanned
import android.text.style.RelativeSizeSpan
import com.compi1.nodepad.src.text_output.SizeText

class Formatter {

    public fun style (text: String){

    }

    public fun size (sizeText:SizeText ): SpannableString{
        //Texto del titulo
        val body = sizeText.body.toString()
        //Tamanio del titulo
        val size = sizeText.size
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

    public fun list(text: String){

    }

}