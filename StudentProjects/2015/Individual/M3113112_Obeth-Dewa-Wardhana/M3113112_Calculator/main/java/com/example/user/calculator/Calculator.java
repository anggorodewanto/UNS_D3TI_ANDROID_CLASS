package com.example.asus.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calculator extends AppCompatActivity implements View.OnClickListener{
    private Button erAdd, erSubtract, erDivide, erMultiply;
    private TextView erResult;
    private EditText erFirst, erSecond;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        init();

     }

    private void init() {
        erAdd=(Button)findViewById(R.id.Add);
        erSubtract=(Button)findViewById(R.id.Subtract);
        erDivide=(Button)findViewById(R.id.Divide);
        erMultiply=(Button)findViewById(R.id.Multiply);

        erFirst=(EditText)findViewById(R.id.FirstN);
        erSecond=(EditText)findViewById(R.id.SecondN);

        erResult=(TextView)findViewById(R.id.Result);

        erAdd.setOnClickListener(this);
        erSubtract.setOnClickListener(this);
        erDivide.setOnClickListener(this);
        erMultiply.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calculator, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        String nmul1 = erFirst.getText().toString();
        String nmul2 = erSecond.getText().toString();
        switch (view.getId()){
            case R.id.Add:
                int addition = Integer.parseInt(nmul1)+Integer.parseInt(nmul2);
                erResult.setText(String.valueOf(addition));
                break;
            case R.id.Subtract:
                int subtraction = Integer.parseInt(nmul1)-Integer.parseInt(nmul2);
                erResult.setText(String.valueOf(subtraction));
                break;
            case R.id.Divide:
                try{
                    int devision = Integer.parseInt(nmul1)/Integer.parseInt(nmul2);
                    erResult.setText(String.valueOf(devision));
                }catch (Exception e){
                    erResult.setText("Connot Divide");
                }
                break;
            case R.id.Multiply:
                int multiply = Integer.parseInt(nmul1)*Integer.parseInt(nmul2);
                erResult.setText(String.valueOf(multiply));
                break;
        }
    }
}
