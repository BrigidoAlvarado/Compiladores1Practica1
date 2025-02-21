package com.compi1.nodepad

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.main_layout)
        val textButton: Button = findViewById(R.id.textButtom)
        //Layout que esta en el scroll panel y que contendra a las celdas


        textButton.setOnClickListener{
            val cellsContainer: LinearLayout = findViewById(R.id.cells_container_layout)
            textButton.setText("PRESIONADO")
            val textTes: TextView = TextView(this).apply {
                text = "Se ha creado una nueva celda"
                textSize = 16f
                setPadding(16,16,16,61)
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
            }
            cellsContainer.addView(textTes)
            val inflaterContainer: LayoutInflater = LayoutInflater.from(this)
            val newCell: View = inflaterContainer.inflate(R.layout.cell_layout, cellsContainer, false)
            cellsContainer.addView(newCell)
        }

    }
}