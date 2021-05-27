package com.example.loginapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;

    EditText usuario, senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //INICIALIZE FIRE BASE AUTH
        mAuth = FirebaseAuth.getInstance();

        usuario = findViewById(R.id.id_email);
        senha = findViewById(R.id.id_senha);
    }

    public void validarUsuario(View view) {
        String email = usuario.getText().toString();
        String password = senha.getText().toString();

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            Intent it = new Intent(MainActivity.this, CadastrarActivity.class);

                            Toast.makeText(MainActivity.this, "Sucesso!!",
                                    Toast.LENGTH_SHORT).show();
                            startActivity(it);

                        } else {

                            Toast.makeText(MainActivity.this, "Falha, tente novamente!",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }
    public void criarUsuario (View view) {
        String email = usuario.getText().toString();
        String password = senha.getText().toString();

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(MainActivity.this, "Sucesso!!",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            // If sign in fails, display a message to the user.

                            Toast.makeText(MainActivity.this, "Falha, tente novamente!",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
    }