package fr.ensitech.dodoapp.services;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.widget.Toast;

public class SonnerieService extends Service {
    MediaPlayer mediaPlayer;

    public SonnerieService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Service démarré", Toast.LENGTH_LONG).show();
        mediaPlayer = MediaPlayer.create(this,Settings.System.DEFAULT_RINGTONE_URI);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
        Toast.makeText(this, "Sonnerie en cours", Toast.LENGTH_LONG).show();
        return super.onStartCommand(intent,flags,startId);
    }

    @Override
    public void onCreate(){
        super.onCreate();
    }


    @Override
    public void onDestroy() {
        mediaPlayer.stop();
        Toast.makeText(this, "Sonnerie terminée", Toast.LENGTH_LONG).show();

    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}