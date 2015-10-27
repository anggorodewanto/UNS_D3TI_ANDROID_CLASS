package com.example.user.tugaskelompok3;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by USER on 13/10/2015.
 */
public class TextFragment extends Fragment {
    TextView text,version;

    @Override

    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.text_fragment, container, false);
        text= (TextView) view.findViewById(R.id.AndroidOs);
        version= (TextView)view.findViewById(R.id.Version);


        return view;

    }
    public void change(String txt, String txt1){
        text.setText(txt);
        version.setText(txt1);

    }
}
