package com.example.pintiaapp

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultadosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultados)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val sharedPreferences: SharedPreferences = getSharedPreferences("Resultados", MODE_PRIVATE)
        val aciertos1 = sharedPreferences.getInt("aciertos1", 0)
        val aciertos2 = sharedPreferences.getInt("aciertos2", 0)
        val aciertos3 = sharedPreferences.getInt("aciertos3", 0)
        val aciertos4 = sharedPreferences.getInt("aciertos4", 0)
        val aciertosTotales = aciertos1 + aciertos2 + aciertos3 + aciertos4
        val porcentaje = aciertosTotales.toDouble() / 8 * 100

        val textViewResultados = findViewById<TextView>(R.id.resultados)
        textViewResultados.text = "Trama urbana de la ciudad Vaccea: $aciertos1" +
                "\nForo de la ciudad romana: $aciertos2" +
                "\nTrama urbana de época romana: $aciertos3" +
                "\nLos hoyos: $aciertos4" +
                "\nTotal: $aciertosTotales ($porcentaje%)"

        val backButton = findViewById<ImageButton>(R.id.atras)
        backButton.setOnClickListener {
            finish()
        }
    }
}