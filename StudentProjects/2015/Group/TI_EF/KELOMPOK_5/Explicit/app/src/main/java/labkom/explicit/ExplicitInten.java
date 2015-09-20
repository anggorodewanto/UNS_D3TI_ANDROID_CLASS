package labkom.explicit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class ExplicitInten extends Activity{
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_inten);
        Button button1=(Button)findViewById(R.id.Button01);

        button1.setOnClickListener(new OnClickListener(){
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ExplicitInten2.class);
                i.putExtra("Value1","Android by Kelompok 5");
                i.putExtra("Value2","Belajar Android");

                startActivity(i);
            }
        });
    }
}