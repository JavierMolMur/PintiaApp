package com.example.pintiaapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.content.Intent
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttonVaccea = findViewById<Button>(R.id.buttonVaccea)
        val buttonForo = findViewById<Button>(R.id.buttonForo)
        val buttonRomana = findViewById<Button>(R.id.buttonRomana)
        val buttonHoyos = findViewById<Button>(R.id.buttonHoyos)
        val buttonResultados = findViewById<Button>(R.id.buttonResultados)

        buttonVaccea.setOnClickListener {
            val intent = Intent(this, InfoTest::class.java)
            intent.putExtra("layout", R.layout.activity_vaccea)
            intent.putExtra("actividad", "vaccea")
            startActivity(intent)
        }

        buttonForo.setOnClickListener {
            val intent = Intent(this, InfoTest::class.java)
            intent.putExtra("layout", R.layout.activity_foro)
            intent.putExtra("actividad", "foro")
            startActivity(intent)
        }

        buttonRomana.setOnClickListener {
            val intent = Intent(this, InfoTest::class.java)
            intent.putExtra("layout", R.layout.activity_romana)
            intent.putExtra("actividad", "romana")
            startActivity(intent)
        }

        buttonHoyos.setOnClickListener {
            val intent = Intent(this, InfoTest::class.java)
            intent.putExtra("layout", R.layout.activity_hoyos)
            intent.putExtra("actividad", "hoyos")
            startActivity(intent)
        }

        buttonResultados.setOnClickListener {
            val intent = Intent(this, ResultadosActivity::class.java)
            startActivity(intent)
        }

        val sharedPreferences = getSharedPreferences("Resultados", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putInt("aciertos1", 0)
        editor.putInt("aciertos2", 0)
        editor.putInt("aciertos3", 0)
        editor.putInt("aciertos4", 0)
        editor.apply()

    }
}