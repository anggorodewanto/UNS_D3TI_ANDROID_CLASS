package com.hanhan481.fragment;

/**
 * Created by Windows 8.1 on 05/01/2016.
 */
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
public class fragmen2 extends fragmen1 {
    @Nullable
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragmen2,container,false);
    }
}
