package fr.ensitech.dodoapp.services;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;

public class NotifService extends Service {
    MediaPlayer mediaPlayer;

    public NotifService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer = MediaPlayer.create(this, Settings.System.DEFAULT_NOTIFICATION_URI);
        mediaPlayer.setLooping(false);
        mediaPlayer.start();
        return super.onStartCommand(intent,flags,startId);
    }

    @Override
    public void onCreate(){
        super.onCreate();
    }


    @Override
    public void onDestroy() {
        mediaPlayer.stop();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}