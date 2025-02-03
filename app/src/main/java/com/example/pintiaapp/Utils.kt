package com.example.pintiaapp

import android.app.AlertDialog
import android.content.Context

object Utils {

    fun calcularAciertos(respuestasUsuario: List<Int>): List<Boolean> {
        return respuestasUsuario.map { it == 1 }
    }

    fun mostrarResultados(context: Context, aciertos: List<Boolean>) {
        val mensaje = "Pregunta 1: ${if (aciertos[0]) "Correcta" else "Incorrecta"} \nPregunta 2: ${if (aciertos[1]) "Correcta" else "Incorrecta"}"

        val builder = AlertDialog.Builder(context)
        builder.setTitle("Resultados")
        builder.setMessage(mensaje)
        builder.setPositiveButton("OK") { dialog, which ->
            dialog.dismiss()
        }
        builder.show()
    }
}