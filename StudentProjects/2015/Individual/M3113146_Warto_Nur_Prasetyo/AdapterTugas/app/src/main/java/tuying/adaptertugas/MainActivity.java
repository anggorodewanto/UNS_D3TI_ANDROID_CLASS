package tuying.adaptertugas;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.text.ChoiceFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> listarray=new ArrayList<String>();
        ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,1);
        LinearLayout.LayoutParams params1=new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        LinearLayout lay0=new LinearLayout(this);
        LinearLayout lay1=new LinearLayout(this);
        LinearLayout lay2=new LinearLayout(this);
        LinearLayout lay3=new LinearLayout(this);
        final EditText edit=new EditText(this);
        final TextView cek=new TextView(this);
        Button add=new Button(this);
        Button del=new Button(this);
        final ListView LS =new ListView(this);
        LS.setId(123);
        LS.setChoiceMode(1);
        lay0.setOrientation(LinearLayout.VERTICAL);
        lay1.setOrientation(LinearLayout.HORIZONTAL);
        lay0.setLayoutParams(params1);
        lay1.setLayoutParams(params1);
        lay3.setLayoutParams(params1);
        edit.setLayoutParams(params);
        add.setLayoutParams(params);
        add.setText("Tambah");
        del.setLayoutParams(params);
        del.setText("Hapus");

        lay1.addView(edit);
        lay1.addView(add);
        lay2.addView(LS);
        lay3.addView(del);
        lay3.addView(cek);
        lay0.addView(lay1);
        lay0.addView(lay2);
        lay0.addView(lay3);

        setContentView(lay0);
        adapter=new ArrayAdapter(this, R.layout.list,listarray);
        final ListView listView=(ListView) findViewById(123);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edit.getText().toString().equals(null) || edit.getText().toString().equals("")){

                }else{
                    listarray.add(edit.getText().toString());
                    adapter.notifyDataSetChanged();
                    edit.setText("");
                }
            }
        });
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listarray.size()==0){

                }else{

//                Integer index =  LS.getSelectedItemPosition();
                    listarray.remove(listarray.size()-1);
//                cek.setText(index);
                    adapter.notifyDataSetChanged();
                }
            }
        });
        listView.setAdapter(adapter);
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
