package d3ti_uns.unitconverter;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

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

        RelativeLayout.LayoutParams Hasil1Params =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        Hasil1Params.addRule(RelativeLayout.ABOVE, convert.getId());
        Hasil1Params.addRule(RelativeLayout.CENTER_HORIZONTAL);
        Hasil1Params.setMargins(0, 50, 0, 20);

        RelativeLayout.LayoutParams HasilParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        HasilParams.addRule(RelativeLayout.BELOW, convert.getId());
        HasilParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        HasilParams.setMargins(0, 60, 0, 20);

        RelativeLayout.LayoutParams buttonParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        buttonParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonParams.setMargins(0, 100, 0, 0);

        mylayout.addView(editText1, textParams);
        mylayout.addView(text1);
        mylayout.addView(convert,buttonParams);

        hasil1 = new TextView(this);
        hasil = new TextView(this);
        hasil1.setText(hasil.getText()+" Fahrenheit");
        mylayout.addView(hasil1, Hasil1Params);

        //hasil = new TextView(this);
        //mylayout.addView(hasil, HasilParams);

        convert.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                //TODO Auto-generated method stub

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