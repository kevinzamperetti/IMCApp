package com.studio.dadosactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnEnviar;
    private EditText edtAltura;
    private EditText edtPeso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getSupportActionBar().hide(); //esconde actionBar com nome do projeto

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEnviar = (Button) findViewById(R.id.btnAvancar);
        edtAltura = (EditText) findViewById(R.id.edtAltura);
        edtPeso = (EditText) findViewById(R.id.edtPeso);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if ( edtAltura.getText().toString().equals("") || edtPeso.getText().toString().equals("") ) {
                    Toast.makeText( getApplicationContext(), "Para calcular o IMC é necessário informar os dois campos", Toast.LENGTH_LONG ).show();
                } else {
                    Intent intent = new Intent(getApplicationContext(), segundaActivity.class);
                    // 1 Parâmetro: Identificador do dado a ser passado, 2 Parâmetro: dado a ser passado - Isso será adicionado na varíavel
                    intent.putExtra("altura", edtAltura.getText().toString());
                    intent.putExtra("peso", edtPeso.getText().toString());
                    startActivity(intent);
                }

            }
        });
    }
}
