package com.example.proyectofinal;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;



public class Register extends AppCompatActivity {

    TextInputEditText editTextNameandSurname, editTextEmail ,editTextContrasena;
    Button button1, button2,button3;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editTextNameandSurname=findViewById(R.id.NomyApe);
        editTextEmail= findViewById(R.id.correoelectronico);
        editTextContrasena= findViewById(R.id.contraseña);
        button1=findViewById(R.id.boton1);
        button2=findViewById(R.id.boton2);
        button3=findViewById(R.id.login_google);
    }
}
