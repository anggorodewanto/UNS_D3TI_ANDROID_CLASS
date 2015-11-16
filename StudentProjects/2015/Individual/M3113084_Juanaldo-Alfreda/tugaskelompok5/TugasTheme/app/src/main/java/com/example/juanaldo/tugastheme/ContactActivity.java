package com.example.juanaldo.tugastheme;

/**
 * Created by baihaqi on 28/10/15.
 */
public class ContactActivity {
    import android.app.ListActivity;
    import android.os.Bundle;
    import android.widget.ArrayAdapter;


    public class ContactActivity extends ListActivity {
        String [] contact ={"Andra", "Dina", "Edo", "Julia"};
        @Override
        public void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.contact);

            setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contact);

        }
    }
}
