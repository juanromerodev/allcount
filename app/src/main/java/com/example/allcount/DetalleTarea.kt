package com.example.allcount

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class DetalleTarea : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_tarea)

        val btnEnviarRegistro= findViewById<Button>(R.id.btnConfirmar);

        btnEnviarRegistro.setOnClickListener{
            val loginScreen = Intent(this, TareaTerminada::class.java)
            startActivity(loginScreen)
        };
    }
}