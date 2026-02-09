package com.example.proyectofinal.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.proyectofinal.login.MainActivity2
import com.example.proyectofinal.R
import com.example.proyectofinal.pagina_principal.Gastos

class MainLoginPorFavor: AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_credenciales)

        val button = findViewById<Button>(R.id.BotonConfirmarCrearCuenta)

        button.setOnClickListener {

            val intent = Intent(this, Gastos::class.java)
            startActivity(intent)

        }
    }
}