package com.example.praktikum7;

import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Getar extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wid_getar);
        Button buton=(Button) findViewById(R.id.button);
        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vibrator vibrator=(Vibrator) getSystemService(VIBRATOR_SERVICE);
                vibrator.vibrate(10000);
                long pattern[] = { 0, 50, 100, 150, 200 };
                vibrator.vibrate(pattern,0);
            }
        });
    }

}

