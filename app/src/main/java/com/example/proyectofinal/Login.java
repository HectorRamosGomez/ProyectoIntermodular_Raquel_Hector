package com.example.proyectofinal;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
public class Login extends AppCompatActivity {
    TextInputEditText editTextNameandSurname, editTextEmail ,editTextContrasena;
    Button button1, button2,button3;
    FirebaseAuth mAuth;
    ProgressBar progressBar;
    TextView textView;
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
        mAuth=FirebaseAuth.getInstance();
        progressBar =findViewById(R.id.progresBar);
        textView=findViewById(R.id.SiYatienecuenta);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Register.class);
                startActivity(intent);
                finish();
            }
            });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                String NomyApe,correoelectronico,contrasena;
                NomyApe=String.valueOf((editTextNameandSurname.getText()));
                correoelectronico= String.valueOf(editTextEmail.getText());
                contrasena=String.valueOf(editTextContrasena.getText());

                if (TextUtils.isEmpty(NomyApe)) {
                    Toast.makeText(Login.this, "Enter name and surname", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(correoelectronico)) {
                    Toast.makeText(Login.this, "Enter email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(contrasena)) {
                    Toast.makeText(Login.this, "enter password", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
    }
}