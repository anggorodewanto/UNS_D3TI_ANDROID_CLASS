package labkom.tugaslistview;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> arrayList = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        LinearLayout layar = new LinearLayout(this);
        TextView layarlist = new TextView(this);
        layar.setOrientation(LinearLayout.VERTICAL);
        layar.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT
        ));
        layarlist.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT
        ));
        Button tambah = new Button(this);
        tambah.setText("Tambah");
        Button hapus = new Button(this);
        hapus.setText("Hapus");
        final EditText editText = new EditText(this);


        ListView tempatlist = new ListView(this);
        tempatlist.setId(147);
        tempatlist.setChoiceMode(1);

        layar.addView(editText);
        layar.addView(tambah);
        layar.addView(hapus);
        layar.addView(tempatlist);
        setContentView(layar);

        final ArrayAdapter adapter = new ArrayAdapter(this, R.layout.list, arrayList);
        ListView list = (ListView) findViewById(147);
        editText.setText("");
        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editText.equals("")) {
                    arrayList.add(editText.getText().toString());
                    adapter.notifyDataSetChanged();
                    editText.setText("");
                }
            }
        });
        hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(arrayList.size()!=0) {
                    arrayList.remove(arrayList.size() - 1);
                    adapter.notifyDataSetChanged();
                }
            }
        });
        list.setAdapter(adapter);
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
