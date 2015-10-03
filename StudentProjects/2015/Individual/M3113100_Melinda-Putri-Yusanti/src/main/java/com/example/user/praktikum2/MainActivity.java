package com.example.user.praktikum2;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void add(View v)
    {
        LinearLayout ll=(LinearLayout)findViewById(R.id.ll);
        TextView result=(TextView)findViewById(R.id.result);
        EditText et1=(EditText)findViewById(R.id.editText1);


        //get value from edit text box and convert into double
        double a=Double.parseDouble(String.valueOf(et1.getText()));
        RadioButton cb=(RadioButton)findViewById(R.id.cb);
        RadioButton fb=(RadioButton)findViewById(R.id.fb);


        //check which radio button is checked
        if(cb.isChecked())
        {
            //change background colour
            ll.setBackgroundColor(Color.YELLOW);
            //display conversion
            result.setText(f2c(a)+" C");
            //cb.setChecked(false);
            fb.setChecked(true);
        }
        else
        {
            ll.setBackgroundColor(Color.CYAN);
            result.setText(c2f(a)+" F ");
            //fb.setChecked(false);
            cb.setChecked(true);
        }
    }
    //Celcius to Fahrenhiet method
    private double c2f(double c)
    {
        return (c*9)/5+32;
    }
    //Fahrenhiet to Celcius method
    private double f2c(double f)
    {
        return (f-32)*5/9;
    }
}
