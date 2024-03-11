package com.example.allcount

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PantallaPrincipal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_principal)

        val btnInicioSesion= findViewById<Button>(R.id.btnInicioSesion);

        btnInicioSesion.setOnClickListener{
            val loginScreen = Intent(this, Login::class.java)
            startActivity(loginScreen)
        };
    }
}