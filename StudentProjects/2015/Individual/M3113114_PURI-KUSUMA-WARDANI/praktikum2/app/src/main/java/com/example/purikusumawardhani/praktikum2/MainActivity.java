package com.example.purikusumawardhani.praktikum2;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends Activity {

  @Override
    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      Button convert;
      final TextView hasil, hasil1;

      RelativeLayout mylayout = new RelativeLayout(this);
      final EditText editText1 = new EditText(this);
      final TextView text1 = new TextView(this);
      mylayout.setBackgroundColor(Color.WHITE);

      editText1.setHint("Masukkan Celcius:");
      editText1.setInputType(3);

    convert = new Button(this);
    convert.setText("Convert");

    RelativeLayout.LayoutParams textParams =
            new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);

    textParams.addRule(RelativeLayout.ABOVE, convert.getId());
    textParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
    textParams.setMargins(0, 20, 0, 20);

    RelativeLayout.LayoutParams hasil1Params =
            new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);

    hasil1Params.addRule(RelativeLayout.ABOVE, convert.getId());
    hasil1Params.addRule(RelativeLayout.CENTER_HORIZONTAL);
    hasil1Params.setMargins(0, 50, 0, 20);

    RelativeLayout.LayoutParams hasilParams =
            new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);

    hasilParams.addRule(RelativeLayout.BELOW, convert.getId());
    hasilParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
    hasilParams.setMargins(0, 60, 0, 20);

    RelativeLayout.LayoutParams buttonParams =
            new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);

    buttonParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
    buttonParams.setMargins(0, 100, 0, 20);

    mylayout.addView(editText1, textParams);
    mylayout.addView(text1);
    mylayout.addView(convert, buttonParams);

    hasil1 = new TextView(this);
    hasil = new TextView(this);
    hasil1.setText(hasil.getText()+" Fahrenheit");
    mylayout.addView(hasil1, hasil1Params);

    convert.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        String value1 = editText1.getText().toString();
        int i = Integer.parseInt(value1);
        double d = ((1.8 * i) + 32);
        String hasil1 = String.valueOf(d);
        text1.setText(hasil1);
      }
    });
    setContentView(mylayout);

  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected (MenuItem item) {
    int id = item.getItemId();

    if (id == R.id.action_settings){
      return  true;
    }
    return super.onOptionsItemSelected(item);
  }
    }