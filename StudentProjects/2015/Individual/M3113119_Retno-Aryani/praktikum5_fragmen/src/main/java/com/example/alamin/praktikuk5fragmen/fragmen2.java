package com.example.alamin.praktikuk5fragmen;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Al'amin on 12/10/2015.
 */
public class fragmen2 extends Fragment {
    @Nullable
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragmen2,container,false);
    }
}
