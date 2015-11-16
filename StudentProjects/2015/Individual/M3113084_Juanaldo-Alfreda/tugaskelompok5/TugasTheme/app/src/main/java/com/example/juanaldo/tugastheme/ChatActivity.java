package com.example.juanaldo.tugastheme;

/**
 * Created by baihaqi on 28/10/15.
 */
public class ChatActivity {
    import android.app.ListActivity;
    import android.os.Bundle;
    import android.widget.ArrayAdapter;

    public class ChatActivity extends ListActivity {
        String [] berita ={"Jadwal Piala Dunia 2014", "Capres Indonesia", "Debat Capres", "Debat Cawapres"};
        @Override
        public void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.chat);

            setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, berita));

        }
    }
}
