package com.example.alone.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by alone on 11/17/2015.
 */
public class service extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    public int onStartCommand(Intent intent, int flags,int startId){
        Toast.makeText(this,"Service Mulai", Toast.LENGTH_LONG).show();
        return START_STICKY;
    }
    public void onDestroy(){
        super.onDestroy();
        Toast.makeText(this,"Service Destroy", Toast.LENGTH_LONG).show();
    }
}
