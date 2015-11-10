package com.example.user.tugaskelompok3;

/**
 * Created by User on 11/10/2015.
 */
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MenuFragment extends ListFragment {
    String[] Food = new String[] { "Nasi Goreng","Mie Ayam","Bakso","Martabak Telor","Siomay","Sate","Capjay","Mie Dog dog","Martabak Manis" };
    String[] Urutan = new String[]{"1","2","3","4","5","6","7","8","9"};
    @Override

    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.list_fragment, container, false);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, Food);
        setListAdapter(adapter);

        return view;

    }
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        TextFragment txt = (TextFragment)getFragmentManager().findFragmentById(R.id.fragment2);
        txt.change(Food[position],"Level : "+Urutan[position]);
        getListView().setSelector(android.R.color.holo_blue_dark);
    }
}
