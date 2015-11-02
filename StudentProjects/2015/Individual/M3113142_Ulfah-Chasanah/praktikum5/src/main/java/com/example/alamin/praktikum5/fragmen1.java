package com.example.alamin.praktikum5;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Al'amin on 15/10/2015.
 */
public class fragmen1 extends Fragment {
    @Nullable
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragmen1,container,false);
    }
}
