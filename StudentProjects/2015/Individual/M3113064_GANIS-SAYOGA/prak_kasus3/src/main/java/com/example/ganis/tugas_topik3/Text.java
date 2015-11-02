package com.example.ganis.tugas_topik3;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
/**
 * Created by Ganis on 10/12/2015.
 */
public class Text extends Fragment {
    TextView text,vers;

    @Override

    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.text_fragment, container, false);
        text= (TextView) view.findViewById(R.id.AndroidOs);
        vers= (TextView)view.findViewById(R.id.Version);


        return view;

    }
    public void change(String txt, String txt1){
        text.setText(txt);
        vers.setText(txt1);

    }
}
