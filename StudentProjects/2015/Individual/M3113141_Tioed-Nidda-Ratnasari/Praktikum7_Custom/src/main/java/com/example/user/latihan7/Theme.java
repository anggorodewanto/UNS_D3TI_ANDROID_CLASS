package com.example.user.latihan7;

/**
 * Created by USER on 11/3/2015.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Theme extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_theme);

        Button btnback = (Button) findViewById(R.id.button1);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                startActivity(new Intent(Theme.this, MainActivity.class));
                finish();
            }
        });
    }
}
