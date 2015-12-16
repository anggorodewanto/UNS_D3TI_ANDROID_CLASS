package com.example.asus8.switchaplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView txtName = (TextView) findViewById(R.id.txtName);
        TextView txtEmail = (TextView) findViewById(R.id.txtEmail);
        Button btnClose = (Button) findViewById(R.id.btnClose);

        Intent i = getIntent();
        //Receiving the data
        String name = i.getStringExtra("name");
        String email = i.getStringExtra("email");

        //Displaying Received data
        txtName.setText(name);
        txtEmail.setText(email);

        btnClose.setOnClickListener(new View.OnClickListener(){
                                       public void onClick(View arg0){
                                           finish();
                                       }
                                    });
    }
}

