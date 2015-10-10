package com.example.indapujilestari.tugas3;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

@SuppressLint("NewApi")
public class Fragment2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.grideview, null);
        GridView listView = (GridView) view.findViewById(R.id.mainGrid);
        listView.setAdapter(new Adapter());
        return view;
    }

    private class Adapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 30;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView image;
            if (convertView == null) {
                image = new ImageView(Fragment2.this.getActivity());
                image.setLayoutParams(new GridView.LayoutParams(100, 100));
                image.setScaleType(ScaleType.FIT_XY);
                convertView = image;
            } else {
                image = (ImageView) convertView;
            }
            return convertView;
        }

    }

}
