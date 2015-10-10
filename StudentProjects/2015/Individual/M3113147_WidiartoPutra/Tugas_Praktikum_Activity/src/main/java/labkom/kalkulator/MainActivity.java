package labkom.kalkulator;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

        LinearLayout layar = new LinearLayout(this);
        LinearLayout baris1 = new LinearLayout(this);
        LinearLayout baris2 = new LinearLayout(this);
        LinearLayout baris3 = new LinearLayout(this);
        LinearLayout baris4 = new LinearLayout(this);
        LinearLayout baris5 = new LinearLayout(this);
        final EditText kotak = new EditText(this);
        final TextView histori = new TextView(this);
        final TextView hasil = new TextView(this);
        final TextView status = new TextView(this);
        kotak.setText("");
        hasil.setText("");
        status.setText("tidak");
        histori.setText("0");


        Button b1 = new Button(this);
        b1.setText("1");
        Button b2 = new Button(this);
        b2.setText("2");
        Button b3 = new Button(this);
        b3.setText("3");
        Button b4 = new Button(this);
        b4.setText("4");
        Button b5 = new Button(this);
        b5.setText("5");
        Button b6 = new Button(this);
        b6.setText("6");
        Button b7 = new Button(this);
        b7.setText("7");
        Button b8 = new Button(this);
        b8.setText("8");
        Button b9 = new Button(this);
        b9.setText("9");
        Button b0 = new Button(this);
        b0.setText("0");
        Button bt = new Button(this);
        Button bku = new Button(this);
        Button bka = new Button(this);
        Button bb = new Button(this);
        Button bc = new Button(this);
        Button bk = new Button(this);
        bt.setText("+");
        bku.setText("-");
        bka.setText("*");
        bb.setText("/");
        bc.setText("C");
        bk.setText(".");
        Button bhit = new Button(this);
        bhit.setText("=");

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        params.weight = 1.0f;

        layar.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        baris1.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        baris2.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        baris3.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        baris4.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        baris5.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        kotak.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        histori.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        b1.setLayoutParams(params);
        b2.setLayoutParams(params);
        b3.setLayoutParams(params);
        b4.setLayoutParams(params);
        b5.setLayoutParams(params);
        b6.setLayoutParams(params);
        b7.setLayoutParams(params);
        b8.setLayoutParams(params);
        b9.setLayoutParams(params);
        b0.setLayoutParams(params);
        bt.setLayoutParams(params);
        bk.setLayoutParams(params);
        bka.setLayoutParams(params);
        bku.setLayoutParams(params);
        bb.setLayoutParams(params);
        bc.setLayoutParams(params);
        bhit.setLayoutParams(params);
        hasil.setLayoutParams(params);

        baris1.setGravity(Gravity.CENTER);
        baris2.setGravity(Gravity.CENTER);
        baris3.setGravity(Gravity.CENTER);
        baris4.setGravity(Gravity.CENTER);
        baris5.setGravity(Gravity.CENTER);
        layar.setGravity(Gravity.CENTER_HORIZONTAL);

        baris1.addView(b1);
        baris1.addView(b2);
        baris1.addView(b3);
        baris1.addView(bt);
        baris2.addView(b4);
        baris2.addView(b5);
        baris2.addView(b6);
        baris2.addView(bku);
        baris3.addView(b7);
        baris3.addView(b8);
        baris3.addView(b9);
        baris3.addView(bka);
        baris4.addView(bc);
        baris4.addView(b0);
        baris4.addView(bb);
        baris4.addView(bhit);
        //baris5.addView(bhit);

        layar.addView(histori);
        layar.addView(kotak);
        layar.addView(baris1);
        layar.addView(baris2);
        layar.addView(baris3);
        layar.addView(baris4);
        //layar.addView(baris5);
        layar.addView(hasil);


        baris1.setOrientation(LinearLayout.HORIZONTAL);
        baris2.setOrientation(LinearLayout.HORIZONTAL);
        baris3.setOrientation(LinearLayout.HORIZONTAL);
        baris4.setOrientation(LinearLayout.HORIZONTAL);
        baris5.setOrientation(LinearLayout.HORIZONTAL);
        layar.setOrientation(LinearLayout.VERTICAL);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(status.getText().equals("tidak")) {
                    kotak.setText(kotak.getText() + "1");
                    kotak.setSelection(kotak.getText().length());
                }else {
                    histori.setText("0");
                    hasil.setText("0");
                    kotak.setText(kotak.getText() + "1");
                    kotak.setSelection(kotak.getText().length());
                    status.setText("tidak");
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(status.getText().equals("tidak")) {
                    kotak.setText(kotak.getText() + "2");
                    kotak.setSelection(kotak.getText().length());
                }else {
                    histori.setText("0");
                    hasil.setText("0");
                    kotak.setText(kotak.getText() + "2");
                    kotak.setSelection(kotak.getText().length());
                    status.setText("tidak");
                }
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(status.getText().equals("tidak")) {
                    kotak.setText(kotak.getText() + "3");
                    kotak.setSelection(kotak.getText().length());
                }else {
                    histori.setText("0");
                    hasil.setText("0");
                    kotak.setText(kotak.getText() + "3");
                    kotak.setSelection(kotak.getText().length());
                    status.setText("tidak");
                }
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(status.getText().equals("tidak")) {
                    kotak.setText(kotak.getText() + "4");
                    kotak.setSelection(kotak.getText().length());
                }else {
                    histori.setText("0");
                    hasil.setText("0");
                    kotak.setText(kotak.getText() + "4");
                    kotak.setSelection(kotak.getText().length());
                    status.setText("tidak");
                }
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(status.getText().equals("tidak")) {
                    kotak.setText(kotak.getText() + "5");
                    kotak.setSelection(kotak.getText().length());
                }else {
                    histori.setText("0");
                    hasil.setText("0");
                    kotak.setText(kotak.getText() + "5");
                    kotak.setSelection(kotak.getText().length());
                    status.setText("tidak");
                }
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(status.getText().equals("tidak")) {
                    kotak.setText(kotak.getText() + "6");
                    kotak.setSelection(kotak.getText().length());
                }else {
                    histori.setText("0");
                    hasil.setText("0");
                    kotak.setText(kotak.getText() + "6");
                    kotak.setSelection(kotak.getText().length());
                    status.setText("tidak");
                }
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(status.getText().equals("tidak")) {
                    kotak.setText(kotak.getText() + "7");
                    kotak.setSelection(kotak.getText().length());
                }else {
                    histori.setText("0");
                    hasil.setText("0");
                    kotak.setText(kotak.getText() + "7");
                    kotak.setSelection(kotak.getText().length());
                    status.setText("tidak");
                }
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(status.getText().equals("tidak")) {
                    kotak.setText(kotak.getText() + "8");
                    kotak.setSelection(kotak.getText().length());
                }else {
                    histori.setText("0");
                    hasil.setText("0");
                    kotak.setText(kotak.getText() + "8");
                    kotak.setSelection(kotak.getText().length());
                    status.setText("tidak");
                }
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(status.getText().equals("tidak")) {
                    kotak.setText(kotak.getText() + "9");
                    kotak.setSelection(kotak.getText().length());
                }else {
                    histori.setText("0");
                    hasil.setText("0");
                    kotak.setText(kotak.getText() + "9");
                    kotak.setSelection(kotak.getText().length());
                    status.setText("tidak");
                }
            }
        });

        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(status.getText().equals("tidak")) {
                    kotak.setText(kotak.getText() + "0");
                    kotak.setSelection(kotak.getText().length());
                }else {
                    histori.setText("0");
                    hasil.setText("0");
                    kotak.setText(kotak.getText() + "0");
                    kotak.setSelection(kotak.getText().length());
                    status.setText("tidak");
                }
            }
        });

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(histori.getText().equals("0") & !kotak.getText().toString().equals("")) {
                    histori.setText(kotak.getText() + " + ");
                    hasil.setText(kotak.getText());
                    kotak.setText("");
                    kotak.setSelection(kotak.getText().length());
                } else if(!histori.getText().equals("0") & !kotak.getText().toString().equals("")) {
                    int lama,baru,jumlah;
                    lama=Integer.parseInt(hasil.getText().toString());
                    baru=Integer.parseInt(kotak.getText().toString());
                    jumlah=lama+baru;
                    hasil.setText(Integer.toString(jumlah));
                    histori.setText(histori.getText() + " " + kotak.getText() +" + ");
                    kotak.setText("");
                } else {
                    kotak.setText("");
                }
            }
        });

        bku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(histori.getText().equals("0") & !kotak.getText().toString().equals("")) {
                    histori.setText(kotak.getText() + " - ");
                    hasil.setText(kotak.getText());
                    kotak.setText("");
                    kotak.setSelection(kotak.getText().length());
                } else if(!histori.getText().equals("0") & !kotak.getText().toString().equals("")) {
                    int lama,baru,jumlah;
                    lama=Integer.parseInt(hasil.getText().toString());
                    baru=Integer.parseInt(kotak.getText().toString());
                    jumlah=lama-baru;
                    hasil.setText(Integer.toString(jumlah));
                    histori.setText(histori.getText() + " " + kotak.getText() +" - ");
                    kotak.setText("");
                } else {
                    kotak.setText("");
                }
            }
        });

        bka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(histori.getText().equals("0") & !kotak.getText().toString().equals("")) {
                    histori.setText(kotak.getText() + " + ");
                    hasil.setText(kotak.getText());
                    kotak.setText("");
                    kotak.setSelection(kotak.getText().length());
                } else if(!histori.getText().equals("0") & !kotak.getText().toString().equals("")) {
                    int lama,baru,jumlah;
                    lama=Integer.parseInt(hasil.getText().toString());
                    baru=Integer.parseInt(kotak.getText().toString());
                    jumlah=lama*baru;
                    hasil.setText(Integer.toString(jumlah));
                    histori.setText(histori.getText() + " " + kotak.getText() +" * ");
                    kotak.setText("");
                } else {
                    kotak.setText("");
                }
            }
        });

        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(histori.getText().equals("0") & !kotak.getText().toString().equals("")) {
                    histori.setText(kotak.getText() + " + ");
                    hasil.setText(kotak.getText());
                    kotak.setText("");
                    kotak.setSelection(kotak.getText().length());
                } else if(!histori.getText().equals("0") & !kotak.getText().toString().equals("")) {
                    int lama,baru,jumlah;
                    lama=Integer.parseInt(hasil.getText().toString());
                    baru=Integer.parseInt(kotak.getText().toString());
                    jumlah=lama/baru;
                    hasil.setText(Integer.toString(jumlah));
                    histori.setText(histori.getText() + " " + kotak.getText() +" / ");
                    kotak.setText("");
                } else {
                    kotak.setText("");
                }
            }
        });

        bhit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (histori.getText().equals("0") & !kotak.getText().toString().equals("")) {
                    histori.setText(kotak.getText());
                    hasil.setText(kotak.getText());
                    kotak.setText("");
                    status.setText("iya");
                    kotak.setSelection(kotak.getText().length());
                } else if (!histori.getText().equals("0") & !kotak.getText().toString().equals("")) {
                    int lama, baru, jumlah;
                    lama = Integer.parseInt(hasil.getText().toString());
                    baru = Integer.parseInt(kotak.getText().toString());
                    jumlah = lama + baru;
                    hasil.setText(Integer.toString(jumlah));
                    histori.setText(histori.getText() + " " + kotak.getText());
                    kotak.setText("");
                    status.setText("iya");
                } else {
                    int lama, baru, jumlah;
                    lama=0;
                    if (!hasil.getText().toString().equals("")) {
                        lama = Integer.parseInt(hasil.getText().toString());
                    }
                    baru = 0;
                    jumlah = lama + baru;
                    hasil.setText(Integer.toString(jumlah));
                    histori.setText(histori.getText() + " 0");
                    kotak.setText("");
                    status.setText("iya");
                }
            }
        });

        bc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kotak.setText("");
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
