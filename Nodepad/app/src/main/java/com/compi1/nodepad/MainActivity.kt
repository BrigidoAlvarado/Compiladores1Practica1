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
import com.compi1.nodepad.src.translate.TextTranslate

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


        //ACCION QUE EJECUTA EL BOTON DE AGREGAR CELDA DE TEXTO
        addTexButton.setOnClickListener{

            //Se infla el layout que contiene la celda de texto para que se pueda agregar al layout principal
            val inflaterContainer: LayoutInflater = LayoutInflater.from(this)
            //Se crea un nueva celda de texto y se agrega al layout que contiene a las celdas
            val newCellText: View = inflaterContainer.inflate(R.layout.text_cell_layout, cellsContainer, false)
            cellsContainer.addView(newCellText)

            //CONFIGURACION DE LOS COMPONENETES DE LA CELDA DE TEXTO

            // Acceder a los elementos de la celda de texto
            val cellButtonText: Button = newCellText.findViewById(R.id.execute_buttom)
            val outputTextView: TextView = newCellText.findViewById(R.id.outputTexView)
            val cellInputText: EditText = newCellText.findViewById(R.id.inputTexteditText)

            //Accion del boton ejecutar de la celda de texto
            cellButtonText.setOnClickListener{
                val textTranslate = TextTranslate()
                //Se envia el output para su traduccion
                val translateResult = textTranslate.translate(cellInputText.text.toString())
                outputTextView.text = translateResult
            }
        }


        //ACCCION QUE EJECUTA EL BOTON DE AGREGAR CODIGO
        addCodeButton.setOnClickListener{

            //Se infla el layout que contiene al celda de codigo para que se pueda agregar al layout principal
            val inflaterCellCode: LayoutInflater = LayoutInflater.from(this)
            //Se crea una nueva celda de codigo y se agregal al layout que contiene la celdas
            val newCellCode: View = inflaterCellCode.inflate(R.layout.code_cell_layout, cellsContainer, false)
            cellsContainer.addView(newCellCode)

            //CONFIGUARACION DE LOS COMPONENTES DE LA CELDA DE CODIGO

            //Acceder a los elementos de la celda de codigo
            val cellButtonCode: Button = newCellCode.findViewById(R.id.executeButtomCode)
            val cellTextViewCode: TextView = newCellCode.findViewById(R.id.outputCodeView)
            val cellInputCode: EditText = newCellCode.findViewById(R.id.inputCodeEditText)

            //Accion del boton de ejecutar de la celda de codigo
            cellButtonCode.setOnClickListener{
                cellTextViewCode.text = "El individuo a escrito " + cellInputCode.text.toString()

            }

        }
    }
}