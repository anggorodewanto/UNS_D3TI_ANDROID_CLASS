package d3ti_uns.implicit;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import m3113123_ridwan_yoga_pradana.implicit.R;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText editText1 = (EditText)findViewById(R.id.editText1);

        Button button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            String url = editText1.getText().toString();
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q= "+ url));
            startActivity(intent);
        }
        });
    }
}