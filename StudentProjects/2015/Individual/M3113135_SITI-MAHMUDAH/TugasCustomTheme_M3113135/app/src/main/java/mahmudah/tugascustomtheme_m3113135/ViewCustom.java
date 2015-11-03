package mahmudah.tugascustomtheme_m3113135;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by user on 01/11/15.
 */
public class ViewCustom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewcustom);

        Button btnback = (Button) findViewById(R.id.button1);

        Intent i = this.getIntent();
        Button btn1 =(Button)findViewById(R.id.button1);
        TextView teks1 = (TextView)findViewById(R.id.textView1);
        TextView teks2 = (TextView)findViewById(R.id.textView2);
        TextView teks3 = (TextView)findViewById(R.id.textView3);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                startActivity(new Intent(ViewCustom.this, MainActivity.class));
                finish();
            }
        });
    }
}
