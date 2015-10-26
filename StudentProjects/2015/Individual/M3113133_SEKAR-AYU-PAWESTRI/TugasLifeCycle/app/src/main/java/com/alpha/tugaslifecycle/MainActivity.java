package com.alpha.tugaslifecycle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

        public class MainActivity extends AppCompatActivity implements View.OnClickListener {
        private Button erTambah, erKurang, erBagi, erKali;
        private TextView erResult;
        private EditText erFirst, erSecond;

                @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                init();
            }

                private void init() {
                erTambah=(Button)findViewById(R.id.Tambah);
                erKurang=(Button)findViewById(R.id.Kurang);
                erBagi=(Button)findViewById(R.id.Bagi);
                erKali=(Button)findViewById(R.id.Kali);
                    erFirst=(EditText)findViewById(R.id.FirstN);
                erSecond=(EditText)findViewById(R.id.SecondN);

                        erResult=(TextView)findViewById(R.id.Result);

                        erTambah.setOnClickListener(this);
                erKurang.setOnClickListener(this);
                erBagi.setOnClickListener(this);
                erKali.setOnClickListener(this);
            }

                    @Override
        public boolean onCreateOptionsMenu(Menu menu) {
                // Inflate the menu; this adds items to the action bar if it is present.
                        getMenuInflater() .inflate(R.menu.menu_main, menu);
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

                @Override
        public void onClick(View view) {
                String nmul1 = erFirst.getText().toString();
                String nmul2 = erSecond.getText().toString();
                switch (view.getId()) {
                        case R.id.Tambah:
                                int addition = Integer.parseInt(nmul1) + Integer.parseInt(nmul2);
                                erResult.setText(String.valueOf(addition));
                                break;
                        case R.id.Kurang:
                                int subtraction = Integer.parseInt(nmul1) - Integer.parseInt(nmul2);
                                erResult.setText(String.valueOf(subtraction));
                                break;
                        case R.id.Bagi:
                                try {
                                        int devision = Integer.parseInt(nmul1) / Integer.parseInt(nmul2);
                                        erResult.setText(String.valueOf(devision));
                                    } catch (Exception e) {
                                        erResult.setText("Tidak dapat dibagi");
                                    }
                                break;
                        case R.id.Kali:
                                int multiply = Integer.parseInt(nmul1) * Integer.parseInt(nmul2);
                                erResult.setText(String.valueOf(multiply));
                                break;
                    }
            }
    }