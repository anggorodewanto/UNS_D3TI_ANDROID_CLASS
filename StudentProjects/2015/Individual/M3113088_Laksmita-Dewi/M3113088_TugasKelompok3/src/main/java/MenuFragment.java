package com.example.m3113088_tugas_kelompok3;
/**
 * Created by 8 on 13/10/15.
 */
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MenuFragment extends ListFragment {
    String[] MenuBurjo = new String[] { "Mie dok dok","Indomie rebus","Nasi Goreng","Magelangan","Nasi Sarden","Es Teh","Bubur Kacang Ijo","Es Goodday","Teh Panas" };
    String[] Harga = new String[]{"Rp.7500","Rp.6500","Rp.7500","Rp.8000","Rp.5500","Rp.5500","Rp.5000","Rp.3500","Rp.2000"};
    @Override

    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.list_fragment, container, false);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, MenuBurjo);
        setListAdapter(adapter);

        return view;

    }
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        TextFragment txt = (TextFragment)getFragmentManager().findFragmentById(R.id.fragment2);
        txt.change(MenuBurjo[position],"Harga : "+Harga[position]);
        getListView().setSelector(android.R.color.holo_blue_dark);
    }
}

