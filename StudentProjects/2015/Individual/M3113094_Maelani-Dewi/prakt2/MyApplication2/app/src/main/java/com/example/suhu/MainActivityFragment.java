package com.example.suhu;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
        private Spinner sp;
        private EditText edt_awal, edt_C, edt_R, edt_F, edt_K;
        private String[] list={"C","R","F","K"};
        Double awal, celsius, reamur,  fahreinheit, kelvin;
        ArrayAdapter adapter;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }
}
