package com.example.luby.tugasmateri1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TugasMateri1 extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tugas_materi1);

        Button runWebsite = (Button) findViewById(R.id.runWebsite);
        runWebsite.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditText website = (EditText) findViewById(R.id.website);
                String strURL = website.getText().toString();
                if (strURL.indexOf("http://") < 0) {
                    strURL = "http://" + strURL;
                }
                Intent implicit = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(strURL));
                startActivity(implicit);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

}

