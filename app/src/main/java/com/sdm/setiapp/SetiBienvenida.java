package com.sdm.setiapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class SetiBienvenida extends AppCompatActivity {

    MediaPlayer miCancion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seti_bienvenida);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        miCancion = MediaPlayer.create(SetiBienvenida.this, R.raw.fonsi);
        miCancion.start();

        Thread reloj = new Thread(){
            public void run(){
                try{
                    sleep(9000);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    Intent abrirInicio = new Intent("android.intent.action.INICIO");
                    startActivity(abrirInicio);
                }
            }
        };
        reloj.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        miCancion.release();
        finish();
    }

}


