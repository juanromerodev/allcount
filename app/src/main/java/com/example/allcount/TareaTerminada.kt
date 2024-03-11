package com.example.allcount

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class TareaTerminada : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tarea_terminada)

        // Obtener la fecha y hora actual
        val cal = Calendar.getInstance()
        val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault())
        val formattedDate = dateFormat.format(cal.time)

        // Mostrar la fecha y hora actual en un TextView
        val textView: TextView = findViewById(R.id.textView)
        textView.text = "Fecha y hora: " + formattedDate

        val btnRegresar= findViewById<Button>(R.id.btnRegresar);

        btnRegresar.setOnClickListener{
            val loginScreen = Intent(this, Bienvenida::class.java)
            startActivity(loginScreen)
        };
    }
}