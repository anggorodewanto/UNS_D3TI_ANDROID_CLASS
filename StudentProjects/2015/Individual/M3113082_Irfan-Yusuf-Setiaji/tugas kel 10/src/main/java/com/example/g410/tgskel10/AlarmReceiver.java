package com.example.g410.tgskel10;

/**
 * Created by G410 on 23/12/2015.
 */
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {
    MediaPlayer player;

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub
        Toast.makeText(context, "Alarm aktif!", Toast.LENGTH_LONG).show();
        player = MediaPlayer.create(context, R.raw.alarm);
        player.start();
    }

}