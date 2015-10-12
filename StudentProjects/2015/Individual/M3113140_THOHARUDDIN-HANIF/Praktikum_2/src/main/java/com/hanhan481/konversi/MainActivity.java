package com.hanhan481.konversi;

        import android.app.ActionBar;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.text.InputType;
        import android.view.Gravity;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.LinearLayout;
        import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView title = new TextView(this);
        final EditText input = new EditText(this);
        Button buton = new Button(this);
        final TextView hasil = new TextView(this);

        title.setText("Konversi Celcius ke Fahrenheit");
        title.setTextSize(14);
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        input.setGravity(Gravity.CENTER);
        buton.setGravity(Gravity.CENTER);
        buton.setText("Submit");

        LinearLayout tampil = new LinearLayout(this);

        tampil.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        title.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        input.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        buton.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        tampil.setOrientation(LinearLayout.VERTICAL);
        tampil.setGravity(Gravity.CENTER);

        tampil.addView(title);
        tampil.addView(input);
        tampil.addView(buton);
        tampil.addView(hasil);

        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float angka = Float.parseFloat(input.getText().toString());
                hasil.setText(String.valueOf(angka * 9 / 5 + 32) + " °F");
            }
        });

        setContentView(tampil);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}