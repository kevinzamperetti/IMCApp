package com.studio.dadosactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;
import java.util.Locale;

public class segundaActivity extends AppCompatActivity {

    private TextView textViewIMC;
    private TextView textViewClassificacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getSupportActionBar().hide(); //esconde actionBar com nome do projeto

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        textViewIMC = (TextView) findViewById(R.id.textViewIMC);
        textViewClassificacao = (TextView) findViewById(R.id.textViewClassificacao);

        Bundle extra = getIntent().getExtras();

        Intent intent = getIntent();
        if(extra != null){
            String nomePassado = extra.getString("nome");
            String alturaPassada = intent.getStringExtra("altura");
            String pesoPassado = intent.getStringExtra("peso");
            Double peso = Double.parseDouble(pesoPassado), altura = Double.parseDouble(alturaPassada), imc;

            imc = (Double) ( peso / ( altura * altura ) );
            textViewIMC.setText("IMC: " + Double.valueOf(String.format(Locale.US, "%.2f", imc)));
            textViewClassificacao.setText( verificaClassificacao( imc ) );
        }
    }

    private String verificaClassificacao( Double imc ) {
        if( imc <= 18.5 ) {
            return "Atenção! Você está Abaixo do peso.";
        } else if ( imc >= 18.6 && imc <= 28.9 ) {
            return ( "Você está no Peso ideal." );
        } else if ( imc >= 25 && imc <= 29.9 ) {
            return "Atenção! Você está com Sobrepeso.";
        } else if( imc >= 30 && imc <= 34.9 ) {
            return "Atenção! Você está com Obesidade Grau I.";
        } else if ( imc >= 35 && imc <= 39.9 ) {
            return "Atenção! Você está com Obesidade Grau II.";
        } else {
            return "Atenção! Você está com Obesidade Grau III.";
        }
    }
}
