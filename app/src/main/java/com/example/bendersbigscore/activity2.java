package com.example.bendersbigscore;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;


public class activity2 extends AppCompatActivity implements View.OnClickListener {

    //Variables que vamos a necesitar para el juego
    private TextView caja;
    ImageView primera;
    ImageView segunda;
    ImageView tercera;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Hacemos la llamada a los datos que traemos del primer activity
        Bundle extras = getIntent().getExtras();
        String s = extras.getString("jugador");
        int i = extras.getInt("edad");

        //Sacamos por pantalla el nombre en el tvNombre
        caja = (TextView)findViewById(R.id.tvNombre);
        caja.setText(s);

        //Variables de los tres ImageView con los que vamos a jugar
        primera = (ImageView) findViewById(R.id.iV1);
        segunda = (ImageView) findViewById(R.id.iV2);
        tercera = (ImageView) findViewById(R.id.iV3);

        primera.setImageResource(R.drawable.f);
        segunda.setImageResource(R.drawable.f);
        tercera.setImageResource(R.drawable.f);


    }
    public void cambiarImagen(View v) {

        //Función a la que llama el boton jugar.
        //En primer lugar sacamos tres números aleatorios
        Random aleatorio = new Random(System.currentTimeMillis()*3);
        Random aleatorio2 = new Random(System.currentTimeMillis()*2);
        Random aleatorio3 = new Random(System.currentTimeMillis()*7);

        int tirada = aleatorio.nextInt(3);
        int tirada2 = aleatorio2.nextInt(3);
        int tirada3 = aleatorio3.nextInt(3);


        //Llamamos a la animación de la entrada de cada imagen del juego
        ImageView foto1 = (ImageView) findViewById(R.id.iV1);
        Animation animacion = AnimationUtils.loadAnimation(this, R.anim.animaciones);
        ImageView foto2 = (ImageView) findViewById(R.id.iV2);
        Animation animacio2 = AnimationUtils.loadAnimation(this, R.anim.animaciones);
        ImageView foto3 = (ImageView) findViewById(R.id.iV3);
        Animation animacio3 = AnimationUtils.loadAnimation(this, R.anim.animaciones);

        //El programa irá buscando el número aleatorio de la tirada y sacará la foto que corresponda
        if (tirada == 0) {
            primera.setImageResource(R.drawable.fry);
            //Entrada con animación de la foto aleatoria
            foto1.startAnimation(animacion);
        } else if (tirada == 1) {
            primera.setImageResource(R.drawable.bender);
            foto1.startAnimation(animacion);
        } else if (tirada == 2) {
            primera.setImageResource(R.drawable.zoiber);
            foto1.startAnimation(animacion);
        }

        if (tirada2 == 0) {
            segunda.setImageResource(R.drawable.fry);
            foto2.startAnimation(animacion);
        } else if (tirada2 == 1) {
            segunda.setImageResource(R.drawable.bender);
            foto2.startAnimation(animacion);
        } else if (tirada2 == 2) {
            segunda.setImageResource(R.drawable.zoiber);
            foto2.startAnimation(animacion);
        }

        if (tirada3 == 0) {
            tercera.setImageResource(R.drawable.fry);
            foto3.startAnimation(animacion);
        } else if (tirada3 == 1) {
            tercera.setImageResource(R.drawable.bender);
            foto3.startAnimation(animacion);
        } else if (tirada3 == 2) {
            tercera.setImageResource(R.drawable.zoiber);
            foto3.startAnimation(animacion);
        }

        //En caso de premio, que las tres imagenes sean iguales.
        if(tirada==tirada2 && tirada2==tirada3){

            //Si el usuario consigue tres imagenes iguales sumará 10 a su puntuación
            TextView tv1 = (TextView) findViewById(R.id.tvPremio);
            String premio = tv1.getText().toString();
            int premioAcumulado = Integer.parseInt(premio);
            premioAcumulado = premioAcumulado + 10;
            String resultado = Integer.toString(premioAcumulado);
            tv1.setText(resultado);

        }else{
            //Si no consigue premio saldrá un mensaje de sigue jugando
            Toast toast1 = Toast.makeText(getApplicationContext(),
                        "Sigue jugando", Toast.LENGTH_SHORT);
            toast1.show();

        }
    }


    public void Salir(View v) {
        //Si pulsamos el botón salir nos devolverá a la pantalla principal
        finish();
        overridePendingTransition(R.anim.zoom,R.anim.zoomout);
    }


    @Override
    public void onClick(View v) {

    }

}
