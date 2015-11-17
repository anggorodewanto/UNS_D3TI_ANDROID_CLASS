package com.example.muawana.cobasaja;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by root on 10/29/15.
 */
public class MainActivity extends Activity {
    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }



    public void startService(View view) {

        startService(new Intent(getBaseContext(), service.class));

    }



    public void stopService(View view) {

        stopService(new Intent(getBaseContext(), service.class));

    }


}

