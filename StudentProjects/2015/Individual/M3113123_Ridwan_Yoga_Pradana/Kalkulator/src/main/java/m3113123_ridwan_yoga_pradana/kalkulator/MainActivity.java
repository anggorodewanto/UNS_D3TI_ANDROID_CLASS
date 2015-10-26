package m3113123_ridwan_yoga_pradana.kalkulator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText a, b;
    private TextView c;
    private Button plus, minus, divide, fold;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a = (EditText) findViewById(R.id.e1);
        b = (EditText) findViewById(R.id.e2);
        c = (TextView) findViewById(R.id.e3);
        plus = (Button) findViewById(R.id.tambah);
        plus.setOnClickListener(this);
        minus = (Button) findViewById(R.id.kurang);
        minus.setOnClickListener(this);
        divide = (Button) findViewById(R.id.bagi);
        divide.setOnClickListener(this);
        fold = (Button) findViewById(R.id.kali);
        fold.setOnClickListener(this);

    }

    public void onClick(View v){
        String angka1 = a.getText().toString();
        String angka2 = b.getText().toString();

        switch (v.getId()) {
            case R.id.tambah:
                int jumlah = Integer.parseInt(angka1) + Integer.parseInt(angka2);
                c.setText(String.valueOf(jumlah));
                break;
            case R.id.kurang:
                int selisih = Integer.parseInt(angka1) - Integer.parseInt(angka2);
                c.setText(String.valueOf(selisih));
                break;
            case R.id.bagi:
                try {
                    int pembagian = Integer.parseInt(angka1) / Integer.parseInt(angka2);
                    c.setText(String.valueOf(pembagian));
                } catch (Exception e) {
                    c.setText("Wrong");
                }
                break;
            case R.id.kali:
                int perkalian = Integer.parseInt(angka1) * Integer.parseInt(angka2);
                c.setText(String.valueOf(perkalian));
                break;
        }
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