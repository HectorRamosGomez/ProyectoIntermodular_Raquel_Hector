package com.example.proyectofinal.login

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.proyectofinal.R

class MainActivity2: AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        val buttonImagen = findViewById<ImageButton>(R.id.btnSpain)

        buttonImagen.setOnClickListener {

            val intent = Intent(this, Registrarse_credenciales::class.java)
            startActivity(intent)
        }

    }
}