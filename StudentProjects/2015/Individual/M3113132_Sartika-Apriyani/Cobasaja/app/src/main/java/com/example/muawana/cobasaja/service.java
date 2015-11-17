package com.example.muawana.cobasaja;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

/**
 * Created by root on 11/17/15.
 */
public class service extends Service {
    @Override
    public IBinder onBind(Intent arg0) {
        return null;

    }



    @Override

    public int onStartCommand(Intent intent, int flags, int startId) {

        // We want this service to continue running until it is explicitly

        // stopped, so return sticky.

        Toast.makeText(this, "The Service Started", Toast.LENGTH_LONG).show();

        return START_STICKY;

    }



    @Override

    public void onDestroy() {

        super.onDestroy();

        Toast.makeText(this, "The Service Destroyed", Toast.LENGTH_LONG).show();

    }
}

