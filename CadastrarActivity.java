package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CadastrarActivity extends AppCompatActivity {

    EditText cod, nome, quant, preco;
    Produto produto;

    FirebaseDatabase database;
    DatabaseReference myRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        cod = findViewById(R.id.id_codigo);
        nome = findViewById(R.id.id_produto);
        quant = findViewById(R.id.id_quantidade);
        preco = findViewById(R.id.id_preco);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("produto");

    }

    public void salvar (View view){
        String codigo, prod;
        Integer quantidade;
        double prec;

          codigo = cod.getText().toString();
          prod = nome.getText().toString();
          quantidade =  Integer.parseInt(quant.getText().toString());
          prec = Double.parseDouble(preco.getText().toString());
          produto = new Produto(codigo,prod,quantidade,prec);

                //é gravado um filho na referência do produtos do Firebase
                myRef.child(produto.getCodigo()).setValue(produto);
                produto = new Produto();
                Toast.makeText(CadastrarActivity.this, "Produto Gravado com Sucesso", Toast.LENGTH_LONG).show();
            }

}