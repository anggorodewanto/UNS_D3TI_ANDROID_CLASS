package com.customtheme.yusuf.tugas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Yusuf on 1/11/2015.
 */

public class CustomView extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_view);

        Button btnkembali = (Button) findViewById(R.id.btnkembali);

        btnkembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                startActivity(new Intent(CustomView.this, MainActivity.class));
                finish();
            }
        });
    }
}
