package edu.fje.dam2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button botojuego;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botojuego= (Button) findViewById(R.id.bt_jugar);
        botojuego.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent botojuego = new Intent(MainActivity.this,M06_CanvasPersonalitzat.class);
                startActivity(botojuego);
            }
        });

    }

}