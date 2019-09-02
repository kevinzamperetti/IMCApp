package com.studio.dadosactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;
import java.util.Locale;

public class segundaActivity extends AppCompatActivity {

    private TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        texto = (TextView) findViewById(R.id.txtView);

        Bundle extra = getIntent().getExtras();
        // metodo em aula
        Intent intent = getIntent();
        if(extra != null){
            String nomePassado = extra.getString("nome");
            String alturaPassada = intent.getStringExtra("altura");
            String pesoPassado = intent.getStringExtra("peso");
            Double peso = Double.parseDouble(pesoPassado), altura = Double.parseDouble(alturaPassada), imc;

            imc = (Double) ( peso / ( altura*altura ) );
            texto.setText("IMC: " + Double.valueOf(String.format(Locale.US, "%.2f", imc)));
        }

    }
}
