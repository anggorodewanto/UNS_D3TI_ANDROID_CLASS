package com.example.user.kelompok1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

tent.Intent;


public class MainActivity extends AppCompatActivity {
    String theUrl = "";
    public WebView Browser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button runWeb = (Button)findViewById(R.id.runWeb);
        runWeb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditText website = (EditText) findViewById(R.id.website);
                String strURL = website.getText().toString();
                if (strURL.indexOf("http://www") < 0) {
                    Intent implicit = onNewIntent(Intent.ACTION_VIEW, Uri.parse(strURL));
                    startActivity(implicit);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }

