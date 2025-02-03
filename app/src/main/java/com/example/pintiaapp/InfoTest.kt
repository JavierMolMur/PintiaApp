package com.example.pintiaapp

import android.app.AlertDialog
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class InfoTest : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val layout = intent.getIntExtra("layout", R.layout.activity_foro)
        setContentView(layout)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val backButton = findViewById<ImageButton>(R.id.atras)
        backButton.setOnClickListener {
            finish()
        }


        val opcionesTest1 = findViewById<RadioGroup>(R.id.opciones_test1)
        val opcionesTest2 = findViewById<RadioGroup>(R.id.opciones_test2)




        val buttonResolver = findViewById<Button>(R.id.buttonResolver)
        buttonResolver.setOnClickListener {

            val opcionSeleccionada1 = findViewById<RadioButton>(opcionesTest1.checkedRadioButtonId)
            val opcionSeleccionada2 = findViewById<RadioButton>(opcionesTest2.checkedRadioButtonId)


            val respuestaUsuario1 = opcionSeleccionada1.tag.toString().toInt()
            val respuestaUsuario2 = opcionSeleccionada2.tag.toString().toInt()

            val respuestasUsuario = listOf(respuestaUsuario1, respuestaUsuario2)

            val aciertos = Utils.calcularAciertos(respuestasUsuario)

            Utils.mostrarResultados(this, aciertos)

            val sharedPreferences = getSharedPreferences("Resultados", MODE_PRIVATE)
            val editor = sharedPreferences.edit()

            val claveAciertos = when (intent.getStringExtra("actividad")) {
                "vaccea" -> "aciertos1"
                "foro" -> "aciertos2"
                "romana" -> "aciertos3"
                "hoyos" -> "aciertos4"
                else -> "aciertos1"
            }
            editor.putInt(claveAciertos, aciertos.count { it })

            editor.apply()

        }


    }


}