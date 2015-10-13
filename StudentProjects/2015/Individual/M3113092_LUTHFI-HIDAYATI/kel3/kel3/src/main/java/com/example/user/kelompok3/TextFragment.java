package com.example.user.kelompok3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by USER on 07/10/2015.
 */
public class TextFragment extends Fragment {
    private static TextView textView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.text_fragment,container, false);
        textView = (TextView) view.findViewById(R.id.text_fragment);
        return view;
    }

    public void changeTextProperties(int fontsize,String text){
        textView.setTextSize(fontsize);
        textView.setText(text);
    }
}
