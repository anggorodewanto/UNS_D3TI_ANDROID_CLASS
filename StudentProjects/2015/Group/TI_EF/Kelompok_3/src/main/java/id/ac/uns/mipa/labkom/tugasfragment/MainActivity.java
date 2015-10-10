package id.ac.uns.mipa.labkom.tugasfragment;

import android.app.ActionBar;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Button tombol1 = new Button(this);
        Button tombol2 = new Button(this);
        Button tombol3 = new Button(this);
        LinearLayout layar = new LinearLayout(this);
        LinearLayout layar2 = new LinearLayout(this);
        tombol1.setText("Biodata");
        tombol2.setText("Cita-cita");
        tombol3.setText("About Me");

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        params.weight = 1.0f;
        tombol1.setLayoutParams(params);
        tombol2.setLayoutParams(params);
        tombol3.setLayoutParams(params);

        final FrameLayout frame = new FrameLayout(this);
        //FrameLayout frame2 = new FrameLayout(this);
        frame.setId(1234);
        //frame2.setId(12);
        FrameLayout.LayoutParams layoutparams=new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT,Gravity.CENTER_HORIZONTAL| Gravity.CENTER_VERTICAL);
        frame.setLayoutParams(layoutparams);
        layar.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        layar2.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        //tombol1.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,33));
        //tombol2.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,33));
        //tombol3.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,33));
        layar.setOrientation(LinearLayout.VERTICAL);
        layar2.setOrientation(LinearLayout.HORIZONTAL);
        layar2.addView(tombol1);
        layar2.addView(tombol2);
        layar2.addView(tombol3);
        layar.addView(layar2);
        layar.addView(frame);
        //layar.addView(frame2);

        final ButtonFragment buttonFragment = new ButtonFragment();
        final Fragmen1 fragmen1 = new Fragmen1();
        final AboutFragment about = new AboutFragment();
        final FragmentManager manager = getFragmentManager();
        FragmentTransaction trans = manager.beginTransaction();
        trans.add(frame.getId(), buttonFragment);
        trans.commit();

        //Button tombol = (Button)findViewById(R.id.button1);

        tombol1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction trans2 = manager.beginTransaction();
                trans2.replace(frame.getId(), fragmen1);
                trans2.commit();
            }
        });

        tombol2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction trans2 = manager.beginTransaction();
                trans2.replace(frame.getId(), buttonFragment);
                trans2.commit();
            }
        });

        tombol3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction trans2 = manager.beginTransaction();
                trans2.replace(frame.getId(), about);
                trans2.commit();
            }
        });

        setContentView(layar);


        //trans.add(R.id.MainContainer, fragmen1, "Fragment2");
        //setContentView(R.layout.activity_main);
        //setContentView(R.layout.activity_main);
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
