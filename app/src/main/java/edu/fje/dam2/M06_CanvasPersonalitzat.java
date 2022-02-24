package edu.fje.dam2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Classe que demostra el funcionament de Canvas.
 * Dibuixa directament sobre una View, utilitza Vistes personalitzades
 * @author sergi.grau@fje.edu
 * @version 5.0 27.01.2020
 */

public class M06_CanvasPersonalitzat extends AppCompatActivity {

    //variable que genera un numero aleatorio
    int valorDado = (int) Math.floor(Math.random()*3+1);

    ArrayList poscolores=new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m06_canvas_personalitzat_principal);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView t = findViewById(R.id.txtaleatorio);
        String s=Integer.toString(valorDado);
        t.setText(s);

        //Recogemos ID de botones
        final Button rojo = findViewById(R.id.bt_rojo);
        final Button amarillo = findViewById(R.id.bt_amarillo);
        final Button verde = findViewById(R.id.bt_verde);
        final Button azul = findViewById(R.id.bt_azul);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int amplada = size.x;
        int alcada = size.y;

        //Posiciones seleccionadas por el usuario
        final ArrayList seleccionusuario=new ArrayList();

        final ArrayList posjugadas=new ArrayList();

      /*  Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int amplada = size.x;
        int alcada = size.y;*/
        int rondas=4;


        ObjectAnimator anim1 = ObjectAnimator.ofFloat(rojo, "alpha", 1f, 0f);
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(amarillo, "alpha", 1f, 0f);
        ObjectAnimator anim3 = ObjectAnimator.ofFloat(verde, "alpha", 1f, 0f);
        ObjectAnimator anim4 = ObjectAnimator.ofFloat(azul, "alpha", 1f, 0f);
        AnimatorSet animacio = new AnimatorSet();


        //hacerTirada();
/*
        for(int i=0;i<4;i++){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int valorDado = (int) Math.floor(Math.random()*3+1);



        switch(valorDado) {

            case 0:
                t.setText(s+"Bloque 0");

                break;
            case 1:
                t.setText(s+"Bloque 1");
                anim1.setDuration(1500);
              //  ObjectAnimator anim1 = ObjectAnimator.ofFloat(rojo, "alpha", 1f, 0f);
               // anim1.setStartDelay(1500);
                anim1.start();
                posjugadas.add(1);

                break;


            case 2:
                t.setText(s+"Bloque 2");

                anim2.setDuration(1500);

                posjugadas.add(2);
               // anim2.start();
               // anim2.setStartDelay(1500);
                anim2.start();
                break;

            case 3:
                t.setText(s+"Bloque 3");

                anim3.setDuration(1500);

                posjugadas.add(3);
               // anim3.start();
                //anim3.setStartDelay(1500);
                anim3.start();
                break;

            case 4:
                t.setText(s+"Bloque 4");
                anim4.setDuration(1500);
                posjugadas.add(4);
                //anim4.setStartDelay(1500);
                anim4.start();
               // anim4.start();
                break;


        }
            //animacio.playSequentially(anim1, anim2, anim3, anim4);


        }
*/


/*
        animacio.playSequentially(anim1, anim2);
        animacio.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator a) {
                super.onAnimationEnd(a);
                //animacio.start();
            }

        });

        animacio.start();*/
/*
        M06_VistaPropia vistaPropia = findViewById(R.id.vista);
        M06_VistaPropia vistaPropia2 = findViewById(R.id.vista2);
        vistaPropia2.setX(120);
        vistaPropia2.setY(140);
        vistaPropia2.setColor(Color.GREEN);
        vistaPropia.setColor(Color.BLUE);*/
        //vistaPropia.setCadena("Android");

//Metodo que crea animacion
   /*     final FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Display display = getWindowManager().getDefaultDisplay();
                Point size = new Point();
                display.getSize(size);
                int amplada = size.x;
                int alcada = size.y;

                ObjectAnimator anim =
                        ObjectAnimator.ofFloat(fab, "y", 0, alcada / 2);
                anim.setDuration(1000);
                anim.start();
                anim = ObjectAnimator.ofFloat(fab, "alpha", 1f, 0f);
                anim.setDuration(1000);
                anim.start();
            }
        });
*/



        //ANIMACION DE LOS BOTONES



        rojo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Display display = getWindowManager().getDefaultDisplay();
                Point size = new Point();
                display.getSize(size);
                int amplada = size.x;
                int alcada = size.y;

                ObjectAnimator anim = ObjectAnimator.ofFloat(rojo, "alpha", 1f, 0f);


                anim.setDuration(1500);
                anim.start();
                seleccionusuario.add("anim1");

                if(seleccionusuario.size()==4){

                    checkIsCorrect(seleccionusuario,poscolores);
                }
            }
        });



        amarillo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Display display = getWindowManager().getDefaultDisplay();
                Point size = new Point();
                display.getSize(size);
                int amplada = size.x;
                int alcada = size.y;

                ObjectAnimator anim = ObjectAnimator.ofFloat(amarillo, "alpha", 1f, 0f);


                anim.setDuration(1500);
                anim.start();

                seleccionusuario.add("anim2");

                if(seleccionusuario.size()==4){

                    checkIsCorrect(seleccionusuario,poscolores);
                }
            }
        });



        verde.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Display display = getWindowManager().getDefaultDisplay();
                Point size = new Point();
                display.getSize(size);
                int amplada = size.x;
                int alcada = size.y;

                ObjectAnimator anim = ObjectAnimator.ofFloat(verde, "alpha", 1f, 0f);


                anim.setDuration(1500);
                anim.start();
                seleccionusuario.add("anim3");

                if(seleccionusuario.size()==4){

                    checkIsCorrect(seleccionusuario,poscolores);
                }

            }
        });



        azul.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Display display = getWindowManager().getDefaultDisplay();
                Point size = new Point();
                display.getSize(size);
                int amplada = size.x;
                int alcada = size.y;

                ObjectAnimator anim = ObjectAnimator.ofFloat(azul, "alpha", 1f, 0f);


                anim.setDuration(1500);
                anim.start();
                seleccionusuario.add("anim4");

                if(seleccionusuario.size()==4){

                    checkIsCorrect(seleccionusuario,poscolores);
                }

            }
        });




        hacerTirada();
    }

    public void hacerTirada(){


        TextView t = findViewById(R.id.txtaleatorio);
        String s=Integer.toString(valorDado);
        t.setText(s);


        final Button rojo = findViewById(R.id.bt_rojo);
        final Button amarillo = findViewById(R.id.bt_amarillo);
        final Button verde = findViewById(R.id.bt_verde);
        final Button azul = findViewById(R.id.bt_azul);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int amplada = size.x;
        int alcada = size.y;


        ArrayList posjugadas=new ArrayList();


      /*  Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int amplada = size.x;
        int alcada = size.y;*/
        int rondas=4;


        ObjectAnimator anim1 = ObjectAnimator.ofFloat(rojo, "alpha", 1f, 0f,1f);
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(amarillo, "alpha", 1f, 0f,1f);
        ObjectAnimator anim3 = ObjectAnimator.ofFloat(verde, "alpha", 1f, 0f,1f);
        ObjectAnimator anim4 = ObjectAnimator.ofFloat(azul, "alpha", 1f, 0f,1f);

        final AnimatorSet animacio = new AnimatorSet();

        int recorre1=0;
        int recorre2=0;
        int recorre3=0;
        int recorre4=0;
         for(int i=0;i<rondas;i++){

             int valorDado = (int) Math.floor(Math.random()*3+1);



        switch(valorDado) {

            case 0:
                //t.setText(s+"Bloque 0");

                break;
            case 1:

                posjugadas.add(anim1);
                poscolores.add("anim1");

                break;



            case 2:

                posjugadas.add(anim2);
                poscolores.add("anim2");

                break;

            case 3:
                posjugadas.add(anim3);
                poscolores.add("anim3");
                break;

            case 4:

                posjugadas.add(anim4);
                poscolores.add("anim4");


                break;

        }

            // anim1.setStartDelay(1300);
             //anim2.setStartDelay(1300);
            // anim3.setStartDelay(1300);
            // anim4.setStartDelay(1300);

           /*  anim4.setRepeatCount(Animation.RESTART);
             anim1.setRepeatCount(Animation.RESTART);
             anim2.setRepeatCount(Animation.RESTART);
             anim3.setRepeatCount(Animation.RESTART);*/


  }


        t.setText(poscolores.toString());

        ObjectAnimator pos1= (ObjectAnimator) posjugadas.get(0);
        ObjectAnimator pos2= (ObjectAnimator) posjugadas.get(1);
        ObjectAnimator pos3= (ObjectAnimator) posjugadas.get(2);
        ObjectAnimator pos4= (ObjectAnimator) posjugadas.get(3);

        pos1.setDuration(2000);

        pos2.setDuration(2000);

        pos3.setDuration(2000);

        pos4.setDuration(2000);
        pos1.start();
        pos2.setStartDelay(2000);
        pos2.start();
        pos3.setStartDelay(2000);
        pos3.start();
        pos4.setStartDelay(2000);
        pos4.start();

        if(pos1.isStarted()){
            pos1.setRepeatCount(Animation.RESTART);
        }else if(pos2.isStarted()){
            pos2.setRepeatCount(Animation.RESTART);
        } if(pos3.isStarted()){
            pos3.setRepeatCount(Animation.RESTART);
        } if(pos4.isStarted()){
            pos4.setRepeatCount(Animation.RESTART);
        }
       // animacio.playSequentially(posjugadas.subList(0,3));
     /*   animacio.playSequentially(pos1,pos2,pos3,pos4);
      //  animacio.playSequentially();
        animacio.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator a) {
                super.onAnimationEnd(a);
                animacio.start();
            }
        });
        animacio.start();*/
    }


    public void checkIsCorrect(ArrayList a,ArrayList b){

        String texto1=a.toString();
        String texto2=b.toString();
        TextView tCheck = findViewById(R.id.txtaleatorio);



        if(a.equals(b)){
            tCheck.setText("Correcto!");
        }else{
            tCheck.setText("Incorrecto!");
        }

    }
}
