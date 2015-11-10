package com.example.ganis.kasus1_m3113064;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Ganis on 9/29/2015.
 */
public class ActivityKedua extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }
        String value1 = extras.getString("value1");
        if (value1 != null) {
            EditText text1 = (EditText) findViewById(R.id.editTextdr1);
            text1.setText(value1);
        }
        Button btnOpen = (Button) findViewById(R.id.btnClose);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                finish(); //close activity
            }
        });
    }
}
