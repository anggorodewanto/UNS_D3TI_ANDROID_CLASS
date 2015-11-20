package com.example.dulpi.mymusic;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MusicService extends Service implements MediaPlayer.OnCompletionListener{
    MediaPlayer player;

    public MusicService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate(){
        super.onCreate();
        start();
        player.setLooping(true);
        play();
    }

    public int onStartCommand(Intent intent, int flags, int startId){
        return START_STICKY;
    }

    public void onDestroy(){
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
        player = MediaPlayer.create(this, R.raw.song);
    }

    @Override
    public void onCompletion(MediaPlayer mp){
        stop();
    }
}
