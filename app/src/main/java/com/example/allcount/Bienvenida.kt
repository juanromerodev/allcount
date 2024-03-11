package com.example.allcount

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Bienvenida : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienvenida)

        val btnInicioSesion= findViewById<Button>(R.id.btnIniciarRegistro);

        btnInicioSesion.setOnClickListener{
            val loginScreen = Intent(this, ListaTareas::class.java)
            startActivity(loginScreen)
        };
    }
}