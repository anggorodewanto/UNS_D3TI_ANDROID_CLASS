package tuying.fragment_tugas;

import android.app.ActionBar;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
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
        LinearLayout layout = new LinearLayout(this);
        LinearLayout menu = new LinearLayout(this);
        LinearLayout fragment1 = new LinearLayout(this);

        final FrameLayout flayout = new FrameLayout(this);
        flayout.setId(123);
        layout.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        final Biodata frag1 = new Biodata();
        final Citacita frag2 = new Citacita();
        final Aboutme frag3 = new Aboutme();

        ActionBar.LayoutParams params = new ActionBar.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,1);

        Button biodata = new Button(this);
        Button citacita = new Button(this);
        Button about = new Button(this);
        biodata.setLayoutParams(params);
        citacita.setLayoutParams(params);
        about.setLayoutParams(params);

        biodata.setText("Biodata");
        citacita.setText("Cita-Cita");
        about.setText("About Me");

        biodata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();
                FragmentTransaction trans = manager.beginTransaction();
                trans.replace(flayout.getId(), frag1, "apalah");
                trans.commit();
            }
        });

        citacita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();
                FragmentTransaction trans = manager.beginTransaction();
                trans.replace(flayout.getId(), frag2, "apalah");
                trans.commit();
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();
                FragmentTransaction trans = manager.beginTransaction();
                trans.replace(flayout.getId(), frag3, "apalah");
                trans.commit();
            }
        });

        FragmentManager manager = getFragmentManager();
        FragmentTransaction trans = manager.beginTransaction();
        trans.add(flayout.getId(), frag1, "apalah");//fragment default saat app dibuka
        trans.commit();

        menu.addView(biodata);
        menu.addView(citacita);
        menu.addView(about);

        fragment1.addView(flayout);

        layout.addView(menu);
        layout.addView(fragment1);

        layout.setOrientation(LinearLayout.VERTICAL);
        setContentView(layout);
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
