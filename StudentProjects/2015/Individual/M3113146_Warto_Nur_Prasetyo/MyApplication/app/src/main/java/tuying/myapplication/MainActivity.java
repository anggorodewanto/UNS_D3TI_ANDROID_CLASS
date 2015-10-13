package tuying.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        RelativeLayout layout = new RelativeLayout();
        final String[] asd = new String[1];
        final String[] tampung = new String[1];
        final String[] result = new String[1];
        final Double[] temp = new Double[1];
        final Double[] hasil = new Double[1];
        result[0]="0";

        final LinearLayout[] layout0 = {new LinearLayout(this)};
        LinearLayout layout1=new LinearLayout(this);
        LinearLayout layout01=new LinearLayout(this);
        LinearLayout layout2=new LinearLayout(this);
        LinearLayout layout3=new LinearLayout(this);
        LinearLayout layout4=new LinearLayout(this);
        LinearLayout layout5=new LinearLayout(this);
        LinearLayout layout6=new LinearLayout(this);
        final TextView textView=new TextView(this);textView.setText("0");
        final TextView label=new TextView(this);label.setText("Result = ");
        final TextView textView2=new TextView(this);textView2.setText("0");
        final EditText editText=new EditText(this);editText.setText("0");
        final Button num1=new Button(this);num1.setText("1");num1.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1));
        final Button num2=new Button(this);num2.setText("2");num2.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,1));
        final Button num3=new Button(this);num3.setText("3");num3.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,1));
        final Button num4=new Button(this);num4.setText("4");num4.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,1));
        final Button num5=new Button(this);num5.setText("5");num5.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,1));
        final Button num6=new Button(this);num6.setText("6");num6.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,1));
        final Button num7=new Button(this);num7.setText("7");num7.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,1));
        final Button num8=new Button(this);num8.setText("8");num8.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,1));
        final Button num9=new Button(this);num9.setText("9");num9.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1));
        final Button num0=new Button(this);num0.setText("0");num0.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1));
        Button plus=new Button(this);plus.setText("+");plus.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1));
        Button min=new Button(this);min.setText("-");min.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1));
        Button div=new Button(this);div.setText("/");div.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1));
        Button multi=new Button(this);multi.setText("*");multi.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1));
        Button clear=new Button(this);clear.setText("C");clear.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1));
        Button samisareng=new Button(this);samisareng.setText("");samisareng.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1));
//
        layout0[0].setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        layout01.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        layout1.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        layout2.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        layout3.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        layout4.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        layout5.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        editText.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        textView2.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        editText.setInputType(InputType.TYPE_CLASS_NUMBER);

        layout01.addView(textView2);layout1.addView(editText);
        layout6.addView(label);layout6.addView(textView);//
        layout2.addView(num1);layout2.addView(num2);layout2.addView(num3);layout2.addView(plus);//
        layout3.addView(num4);layout3.addView(num5);layout3.addView(num6);layout3.addView(min);//
        layout4.addView(num7);layout4.addView(num8);layout4.addView(num9);layout4.addView(multi);//
        layout5.addView(clear);layout5.addView(num0);layout5.addView(samisareng);layout5.addView(div);
        layout0[0].setOrientation(LinearLayout.VERTICAL);

        layout0[0].addView(layout01);
        layout0[0].addView(layout1);
        layout0[0].addView(layout2);
        layout0[0].addView(layout3);
        layout0[0].addView(layout4);
        layout0[0].addView(layout5);
        layout0[0].addView(layout6);

        setContentView(layout0[0]);

        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asd[0] = editText.getText().toString();
                if (asd[0].equals("0")) {
                    editText.setText(num1.getText());
                    tampung[0] = editText.getText().toString();
                } else {
                    editText.setText(asd[0] + num1.getText());
                    tampung[0] = editText.getText().toString();
//                    textView.setText(tampung[0]);
                }
            }
        });
        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asd[0]=editText.getText().toString();
                if (asd[0].equals("0")) {
                    editText.setText(num2.getText());
                    tampung[0]=editText.getText().toString();
//                    textView.setText(tampung[0]);
                } else {
                    editText.setText(asd[0] + num2.getText());
                    tampung[0]=editText.getText().toString();
//                    textView.setText(tampung[0]);
                }
            }
        });
        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asd[0]=editText.getText().toString();
                if (asd[0].equals("0")) {
                    editText.setText(num3.getText());
                    tampung[0]=editText.getText().toString();
//                    textView.setText(tampung[0]);
                } else {
                    editText.setText(asd[0] + num3.getText());
                    tampung[0]=editText.getText().toString();
//                    textView.setText(tampung[0]);
                }
            }
        });
        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asd[0]=editText.getText().toString();
                if (asd[0].equals("0")) {
                    editText.setText(num4.getText());
                    tampung[0]=editText.getText().toString();
//                    textView.setText(tampung[0]);
                } else {
                    editText.setText(asd[0] + num4.getText());
                    tampung[0]=editText.getText().toString();
//                    textView.setText(tampung[0]);
                }
            }
        });
        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asd[0]=editText.getText().toString();
                if (asd[0].equals("0")) {
                    editText.setText(num5.getText());
                    tampung[0]=editText.getText().toString();
//                    textView.setText(tampung[0]);
                } else {
                    editText.setText(asd[0] + num5.getText());
                    tampung[0]=editText.getText().toString();
//                    textView.setText(tampung[0]);
                }
            }
        });
        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asd[0]=editText.getText().toString();
                if (asd[0].equals("0")) {
                    editText.setText(num6.getText());
                    tampung[0]=editText.getText().toString();
//                    textView.setText(tampung[0]);
                } else {
                    editText.setText(asd[0] + num6.getText());
                    tampung[0]=editText.getText().toString();
//                    textView.setText(tampung[0]);
                }
            }
        });
        num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asd[0]=editText.getText().toString();
                if (asd[0].equals("0")) {
                    editText.setText(num7.getText());
                    tampung[0]=editText.getText().toString();
//                    textView.setText(tampung[0]);
                } else {
                    editText.setText(asd[0] + num7.getText());
                    tampung[0]=editText.getText().toString();
//                    textView.setText(tampung[0]);
                }
            }
        });
        num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asd[0]=editText.getText().toString();
                if (asd[0].equals("0")) {
                    editText.setText(num8.getText());
                    tampung[0]=editText.getText().toString();
//                    textView.setText(tampung[0]);
                } else {
                    editText.setText(asd[0] + num8.getText());
                    tampung[0]=editText.getText().toString();
//                    textView.setText(tampung[0]);
                }
            }
        });
        num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asd[0]=editText.getText().toString();
                if (asd[0].equals("0")) {
                    editText.setText(num9.getText());
                    tampung[0]=editText.getText().toString();
//                    textView.setText(tampung[0]);
                } else {
                    editText.setText(asd[0] + num9.getText());
                    tampung[0]=editText.getText().toString();
//                    textView.setText(tampung[0]);
                }
            }
        });
        num0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asd[0]=editText.getText().toString();
                if (asd[0].equals("0")) {
                    editText.setText(num0.getText());
                    tampung[0]=editText.getText().toString();
//                    textView.setText(tampung[0]);
                }else{
                    editText.setText(asd[0] + num0.getText());
                    tampung[0]=editText.getText().toString();
//                    textView.setText(tampung[0]);
                }
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double aw;
                aw=Double.parseDouble(result[0]);
                temp[0]= Double.parseDouble(tampung[0]);
//                hasil[0] = hasil[0] + temp[0];
                aw=aw + temp[0];
                textView.setText(Double.toString(aw));
                result[0]=Double.toString(aw);
                editText.setText("0");
                textView2.setText(textView2.getText().toString()+" + "+tampung[0]);
            }
        });
        min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double aw;
                aw=Double.parseDouble(result[0]);
                temp[0]= Double.parseDouble(tampung[0]);
//                hasil[0] = hasil[0] + temp[0];
                aw=aw - temp[0];
                textView.setText(Double.toString(aw));
                result[0]=Double.toString(aw);
                editText.setText("0");
                textView2.setText(textView2.getText().toString()+" - "+tampung[0]);
            }
        });
        multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double aw;
                aw=Double.parseDouble(result[0]);
                temp[0]= Double.parseDouble(tampung[0]);
//                hasil[0] = hasil[0] + temp[0];
                aw=aw * temp[0];
                textView.setText(Double.toString(aw));
                result[0]=Double.toString(aw);
                editText.setText("0");
                textView2.setText(textView2.getText().toString()+" * "+tampung[0]);
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double aw;
                aw=Double.parseDouble(result[0]);
                temp[0]= Double.parseDouble(tampung[0]);
//                hasil[0] = hasil[0] + temp[0];
                aw=aw / temp[0];
                textView.setText(Double.toString(aw));
                result[0]=Double.toString(aw);
                editText.setText("0");
                textView2.setText(textView2.getText().toString()+" / "+tampung[0]);
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("0");
                textView2.setText("0");
                editText.setText("0");
                result[0]="0";
                tampung[0]="0";
            }
        });

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
