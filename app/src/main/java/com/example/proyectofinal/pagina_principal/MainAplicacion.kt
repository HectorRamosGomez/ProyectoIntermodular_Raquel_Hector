package com.example.proyectofinal.pagina_principal

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.proyectofinal.R

class MainAplicacion : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pagprincipal)

        val button = findViewById<Button>(R.id.botongasto)

        button.setOnClickListener {
            val intent = Intent(this, Gastos::class.java)
            startActivity(intent)


        }
    }
}
