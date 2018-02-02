package com.sdm.setiapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class Inicio extends AppCompatActivity {
    int contador;
    Button sumar, restar;
    TextView mostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        contador = 0;
        sumar = findViewById(R.id.Sumar);
        restar = findViewById(R.id.Restar);
        mostrar = findViewById(R.id.tvMostrar);

        sumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contador += 1;
                mostrar.setText("Su Total es " + contador);
                if (contador == 10)
                    activarReceiver(contador);
            }
        });

        restar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contador -= 1;
                mostrar.setText("Su Total es " + contador);
                if (contador == 10)
                    activarReceiver(contador);
            }
        });
    }
    //

    public void activarReceiver(int c) {
        int i = c;
        Intent intent = new Intent(this, MiBCReceiver.class);
        sendBroadcast(intent);
        Log.i("Receiver", "Intent Enviado");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_inicio, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
