package com.example.allcount

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnInicioSesion= findViewById<Button>(R.id.btnLogin);

        btnInicioSesion.setOnClickListener{
            val loginScreen = Intent(this, Bienvenida::class.java)
            startActivity(loginScreen)
        };
    }
}