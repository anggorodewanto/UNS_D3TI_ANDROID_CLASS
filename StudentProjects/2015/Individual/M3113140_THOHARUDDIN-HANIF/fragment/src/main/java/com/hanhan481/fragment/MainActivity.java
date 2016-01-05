package com.hanhan481.fragment;

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

        Button biodata = new Button(this);
        Button cita = new Button(this);
        Button aboutt = new Button(this);
        LinearLayout layar = new LinearLayout(this);
        LinearLayout layar2 = new LinearLayout(this);
        biodata.setText("Biodata");
        cita.setText("Cita-cita");
        aboutt.setText("About Me");

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        params.weight = 1.0f;
        biodata.setLayoutParams(params);
        cita.setLayoutParams(params);
        aboutt.setLayoutParams(params);

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
        layar2.addView(biodata);
        layar2.addView(cita);
        layar2.addView(aboutt);
        layar.addView(layar2);
        layar.addView(frame);
        //layar.addView(frame2);

        final fragmen3 fragmen3 = new fragmen3();
        final fragmen2 fragmen2 = new fragmen2();
        final fragmen1 fragmen1 = new fragmen1();
        final FragmentManager manager = getFragmentManager();
        FragmentTransaction trans = manager.beginTransaction();
        trans.add(frame.getId(), fragmen2);
        trans.commit();

        //Button tombol = (Button)findViewById(R.id.button1);

        biodata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction trans2 = manager.beginTransaction();
                trans2.replace(frame.getId(), fragmen1);
                trans2.commit();
            }
        });



        cita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction trans2 = manager.beginTransaction();
                trans2.replace(frame.getId(), fragmen2);
                trans2.commit();
            }
        });

        aboutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction trans2 = manager.beginTransaction();
                trans2.replace(frame.getId(), fragmen3);
                trans2.commit();
            }
        });

        setContentView(layar);
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
