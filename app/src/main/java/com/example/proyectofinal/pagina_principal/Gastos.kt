package com.example.proyectofinal.pagina_principal

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.proyectofinal.R

class Gastos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pagprincipal) // tu layout corregido

        // --- Botón atrás ---
        val btnBack = findViewById<ImageButton>(R.id.btnBack)
        btnBack.setOnClickListener {
            finish() // cierra esta actividad y vuelve a la anterior
        }

        // --- EditText para euros ---
        val editEuro = findViewById<EditText>(R.id.editEuro)
        editEuro.hint = "0.00"
        editEuro.inputType = android.text.InputType.TYPE_CLASS_NUMBER or
                android.text.InputType.TYPE_NUMBER_FLAG_DECIMAL

        // --- Spinner para cuentas ---
        val spinnerCuenta = findViewById<Spinner>(R.id.spinnerCuenta)
        val cuentas = listOf("Principal", "Secundaria")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, cuentas)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCuenta.adapter = adapter
    }
}
