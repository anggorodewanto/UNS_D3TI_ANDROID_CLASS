package com.example.setiadidarmawan.customtheme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Setiadi Darmawan on 01-Nov-15.
 */
public class Baru extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitybaru);

        Button tombol2 = (Button) findViewById(R.id.back);

        tombol2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                //TODO Auto-generated method stub
                Intent back = new Intent(Baru.this, MainActivity.class);
                startActivity(back);
            }
        });
    }
}
