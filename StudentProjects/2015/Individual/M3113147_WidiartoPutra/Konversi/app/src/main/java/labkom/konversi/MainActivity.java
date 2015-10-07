package labkom.konversi;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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


        TextView judul = new TextView(this);
        final TextView jawaban = new TextView(this);
        final EditText kotak = new EditText(this);
        Button tombol = new Button(this);
        kotak.setInputType(InputType.TYPE_CLASS_NUMBER);
        tombol.setGravity(Gravity.CENTER);
        kotak.setGravity(Gravity.CENTER);
        judul.setText("Konversi Celcius ke Farenheit");
        //judul.setTextSize(15);
        tombol.setText("Hitung");

        LinearLayout layar = new LinearLayout(this);

        layar.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        kotak.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        judul.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        tombol.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        layar.setOrientation(LinearLayout.VERTICAL);
        layar.setGravity(Gravity.CENTER);

        layar.addView(judul);
        layar.addView(kotak);
        layar.addView(jawaban);
        layar.addView(tombol);

        tombol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float nilai = Float.parseFloat(kotak.getText().toString());
                jawaban.setText(String.valueOf(nilai*9/5+32) + " ᵒF");
            }
        });


        setContentView(layar);
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
