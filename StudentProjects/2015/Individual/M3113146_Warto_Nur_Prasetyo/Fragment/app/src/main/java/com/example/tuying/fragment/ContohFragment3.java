package com.example.tuying.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by 2ying on 10/6/2015.
 */
public class ContohFragment3 extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        TextView text1= new TextView();
        text1.setText("asdasdasdasdasdasd");
        LinearLayout asd=new LinearLayout();
        asd.addView(text1);
//        return inflater.inflate(R.layout.contohfragment3, container, false);
        return inflater.inflate(asd, container, false);
    }
}
