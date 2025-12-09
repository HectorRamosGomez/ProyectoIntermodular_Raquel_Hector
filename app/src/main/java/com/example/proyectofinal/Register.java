package com.example.proyectofinal;
import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.Firebase;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register extends AppCompatActivity {
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
                Intent intent=new Intent(getApplicationContext().Login.class);
                progressBar.setVisibility(View.VISIBLE);
                String NomyApe,correoelectronico,contrasena;
                NomyApe=String.valueOf((editTextNameandSurname.getText()));
                correoelectronico= String.valueOf(editTextEmail.getText());
                contrasena=String.valueOf(editTextContrasena.getText());

                if (TextUtils.isEmpty(NomyApe)) {
                    Toast.makeText(Register.this, "Enter name and surname", Toast.LENGTH_SHORT).show();
                return;
                }
                if (TextUtils.isEmpty(correoelectronico)) {
                    Toast.makeText(Register.this, "Enter email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(contrasena)) {
                    Toast.makeText(Register.this, "enter password", Toast.LENGTH_SHORT).show();
                    return;
                }
                mAuth.createUserWithEmailAndPassword(correoelectronico, contrasena)                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    progressBar.setVisibility(View.GONE);
                                    Toast.makeText(Register.this, "Account created.",
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(Register.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                }
            }
        });
    }
}
