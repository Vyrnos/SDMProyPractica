package com.sdm.setiapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ActividadPrincipal extends AppCompatActivity {
//asd
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table);

        Button bIniciar = (Button) findViewById(R.id.bIniciarSer);
        bIniciar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startService(new Intent(getBaseContext(),MiServicio.class));
            }
        });

        Button bParar = (Button) findViewById(R.id.bPararSer);
        bParar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                stopService(new Intent(getBaseContext(),MiServicio.class));
            }
        });
    }


}
