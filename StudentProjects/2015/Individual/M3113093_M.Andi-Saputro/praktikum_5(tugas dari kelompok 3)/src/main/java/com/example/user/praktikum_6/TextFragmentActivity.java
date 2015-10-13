package com.example.user.praktikum_6;

/**
 * Created by user on 13-Oct-15.
 */

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TextFragmentActivity extends Fragment {

    TextView text,vers,desc;

    @Override

    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.text_fragment, container, false);
        text= (TextView) view.findViewById(R.id.AndroidOs);
        vers= (TextView)view.findViewById(R.id.Version);
        desc= (TextView)view.findViewById(R.id.Description);


        return view;

    }
    public void change(String txt, String txt1, String txt2){
        text.setText(txt);
        vers.setText(txt1);
        desc.setText(txt2);
    }
}
