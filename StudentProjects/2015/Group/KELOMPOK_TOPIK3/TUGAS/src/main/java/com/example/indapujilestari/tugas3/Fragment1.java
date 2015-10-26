package com.example.indapujilestari.tugas3;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

@SuppressLint("NewApi")
public class Fragment1 extends Fragment {

    private String arry[] = { "Example", "Agung", "Fragment" };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ListView listView = new ListView(getActivity());
        ArrayAdapter<String> array = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1);
        for (String str : arry)
            array.add(str);
        listView.setAdapter(array);
        return listView;
    }
}