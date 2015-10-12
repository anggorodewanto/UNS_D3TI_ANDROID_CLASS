package com.example.asuspc.tugaskel1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by ASUS PC on 9/30/2015.
 */
public class MainActivity2 extends Activity{
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }
        String value1 = extras.getString("value1");
        if (value1 != null ) {
            EditText editText = (EditText) findViewById(R.id.editText);
            editText.setText(value1);
        }
        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                finish(); //close activity
            }
        });
    }

    @Override
    public void finish() {
        Intent data = new Intent();
        EditText editText1 = (EditText) findViewById(R.id.editText1);
        String dataactivity2 = editText1.getText().toString();
        data.putExtra("return_value1", dataactivity2);
        setResult(RESULT_OK, data);
        super.finish();
    }
}
