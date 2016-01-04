package com.example.alamin.praktikum8eksan;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

/**
 * Created by user on 17/11/2015.
 */
public class MusicService extends Service implements MediaPlayer.OnCompletionListener {


    MediaPlayer player;
    public IBinder onBind(Intent arg0) {

        return null;
    }



    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        start();
        player.setLooping(true); // Set looping
        play();
    }

    @Override
    public int onStartCommand(Intent intent,int flags, int startId) {
        return START_STICKY;
    }


    public void onDestroy() {
        // TODO Auto-generated method stub
        player.release();
        player=null;
        super.onDestroy();
    }

    public void stop(){
        if(player.isPlaying()){
            player.pause();
        }
    }

    public void play(){
        player.start();
    }

    public void start(){
        player= MediaPlayer.create(this, R.raw.song);

    }


    @Override
    public void onCompletion(MediaPlayer mp) {
        stop();
    }
}
