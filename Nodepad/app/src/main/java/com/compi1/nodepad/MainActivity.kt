package com.compi1.nodepad

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.main_layout)

        //BOTON PARA AGREGAR UNA CELDA DE TEXTO
        val addTexButton: Button = findViewById(R.id.textButton)
        //BOTON PAR AGREGAR UNA CELDA DE CODIGO
        val addCodeButton: Button = findViewById(R.id.codeButton)

        //LAYOUT CONTENEDOR DE CELDAS
        val cellsContainer: LinearLayout = findViewById(R.id.cells_container_layout)


        addTexButton.setOnClickListener{

            // Se infla el layout que tiene el contenido de una celda
            val inflaterContainer: LayoutInflater = LayoutInflater.from(this)
            val newCell: View = inflaterContainer.inflate(R.layout.cell_layout, cellsContainer, false)
            cellsContainer.addView(newCell)

            // Acceder a los elementos de la celda
            val cellButton: Button = newCell.findViewById(R.id.execute_buttom)
            val cellTex: TextView = newCell.findViewById(R.id.test_text)
            val cellInputText: EditText = newCell.findViewById(R.id.inputTexteditText)

            //Accion del boton de la celda
            cellButton.setOnClickListener{

                cellTex.setText("El boton de esta celda ya ha sido presionado \n NO ")
            }

        }

    }
}