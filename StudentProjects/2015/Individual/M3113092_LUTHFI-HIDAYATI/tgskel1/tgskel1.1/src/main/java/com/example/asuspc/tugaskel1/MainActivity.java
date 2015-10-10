package com.example.asuspc.tugaskel1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity{
    public static final int REQUEST_CODE = 1;


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        //set OnClickListener event to button
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                callIntent();
            }
        });
    }

    //method for call MainActivity2
    public void callIntent(){
        Intent i = new Intent(getApplicationContext(), MainActivity2.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String dataactivity1 = editText.getText().toString();
        //untuk mengirim data gunakan putExtra
        i.putExtra("value1", dataactivity1);
        startActivityForResult(i, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            if (data.hasExtra("return_value1")) {
                EditText editText1 = (EditText) findViewById(R.id.editText1);
                editText1.setText(data.getExtras().getString("return_value1"));
            }
        }
    }

}
