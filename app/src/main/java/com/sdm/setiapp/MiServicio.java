package com.sdm.setiapp;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Vlad on 2/1/2018.-.
 */

public class MiServicio extends Service {

    MediaPlayer miCancion;
    private static final String TAG = "Clase MiServicio ";

    @Override
    public IBinder onBind(Intent arg0){
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        Toast.makeText(this,"El Servicio iniciado", Toast.LENGTH_SHORT).show();
        miCancion = MediaPlayer.create(MiServicio.this, R.raw.fonsi);
        miCancion.start();
        Log.i(TAG, "El servicio se ha iniciado");
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Servicio parado", Toast.LENGTH_LONG).show();
        miCancion.stop();
        Log.i(TAG, "El servicio se ha parado");
    }
}
