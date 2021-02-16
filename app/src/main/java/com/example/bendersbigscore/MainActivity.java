package com.example.bendersbigscore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.bEntrar).setOnClickListener(this);

    }
    public void  onClick(View v){
        //Para conectarnos con la siguiente pantalla y llevarnos los datos que queremos.

        //Sacamos los datos del editText etNombre y los metemos en la variable jugador
        EditText editText = (EditText)findViewById(R.id.etNombre);
        String jugador = editText.getText().toString();

        //Sacamos los datos del editText etEdad y los metemos en la variable edad y luego los pasamos a tipo int
        EditText editText1 = (EditText)findViewById(R.id.etEdad);
        String edad = editText1.getText().toString();
        int edadNum = Integer.parseInt(edad);

        //Hacemos una verificación de la edad
        if(edadNum >= 18) {
            //Si es mayor de 18 podrá pasar al siguiente activity
            Intent intent = new Intent(v.getContext(), activity2.class);
            intent.putExtra("jugador", jugador);
            startActivity(intent);
            overridePendingTransition(R.anim.zoom,R.anim.zoomout);
        }else{
            //Si es menor de edad saldrá este mensaje Toast avisando de que no puede entrar
            Toast toast1 = Toast.makeText(getApplicationContext(),
                            "No tienes edad para estos juegos", Toast.LENGTH_SHORT);
            toast1.show();

            }
    }
}