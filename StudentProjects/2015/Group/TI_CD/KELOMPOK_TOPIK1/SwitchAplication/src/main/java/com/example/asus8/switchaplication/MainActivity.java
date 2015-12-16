package com.example.asus8.switchaplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity {

    EditText inputName;
    EditText inputEmail;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputName = (EditText) findViewById(R.id.name);
        inputEmail = (EditText) findViewById(R.id.email);
        Button btnNextScreen = (Button) findViewById(R.id.btnNextScreen);

        btnNextScreen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent nextScreen = new Intent(getApplicationContext(), SecondActivity.class);
                nextScreen.putExtra("name", inputName.getText().toString());
				nextScreen.putExtra("email", inputEmail.getText().toString());
                startActivity(nextScreen);
            }
        });
}
        }

