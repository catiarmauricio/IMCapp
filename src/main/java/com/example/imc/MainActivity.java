package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    //Declaração de variaveis

    int peso;
    float altura;
    float imc;
    String mensagem = "";

    //Declarão de objetos
    EditText editPeso, editAltura;
    TextView txtResultado;
    Button btCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Obts do Layaout
        editPeso = (EditText) findViewById(R.id.peso);
        editAltura = (EditText) findViewById(R.id.altura);
        txtResultado = (TextView) findViewById(R.id.resultado);
        btCalcular = (Button) findViewById(R.id.btCalcular);

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                peso = Integer.parseInt(editPeso.getText().toString());
                altura = Float.parseFloat(editAltura.getText().toString());

                // Calculo
                imc = peso / (altura * altura);

                //mensagens do imc
                if(imc < 18.5) {
                    mensagem = "Abaixo do Peso";
                }else if ((imc >= 18.5) && (imc < 25)) {
                    mensagem = "Peso Ideal!!!!!";
                }else if ((imc >= 25.0) && (imc < 30.0)) {
                    mensagem = "Levemente acima do peso";
                }else if ((imc >= 30.0) && (imc < 35.0)) {
                    mensagem = "Obsidade Grau I";
                }else if ((imc >= 35.0) && (imc < 40.0)) {
                    mensagem = "Obsidade Grau II (Severa)";
                }else {
                    mensagem = "Obsidade Grau III (Mórbida)";
                }

                //Mostrar resultado
                txtResultado.setText("IMC: " + String.valueOf(imc) + "\nMensagem: " + mensagem);

            }
        });

    }
}