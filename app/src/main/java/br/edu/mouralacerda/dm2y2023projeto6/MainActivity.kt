package br.edu.mouralacerda.dm2y2023projeto6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnEnviar).setOnClickListener {

            val carro = Carro(
                findViewById<EditText>(R.id.edtPlaca).text.toString(),
                findViewById<EditText>(R.id.edtMarca).text.toString(),
                findViewById<EditText>(R.id.edtModelo).text.toString(),
                findViewById<EditText>(R.id.edtAno).text.toString().toInt(),
            )

            ClienteWS().enviarCarro(carro)

        }
    }
}