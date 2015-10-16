package com.example.user.praktikum_6;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MenuFragmentActivity extends ListFragment {
    String[] AndroidOS = new String[] { "Cupcake","Donut","Eclair","Froyo","Gingerbread","Honeycomb","Ice Cream SandWich","Jelly Bean","KitKat","lolipop" };
    String[] Version = new String[]{"1.5","1.6","2.0-2.1","2.2","2.3","3.0-3.2","4.0","4.1-4.3","4.4","5.0"};
    String[] Description = new String[]{
            "Sistem android versi 1.0 ini pertama kali hadir di tahun 2008, tepatnya pada oktober 2008",
            "versi ini dirilis pada bulan september 2009 tentu donut sudah tak asing lagi bagi telinga orang Indonesia",
            "vaersi ini Di rilis pada bulan oktober 2009",
            " Versi ini dirilis pada bulan Mei 2010 dengan update memperbaiki segi kecepatan",
            "versi ini dirilis pada bulan desember 2010. Smartphone pertama yang memakai versi android ini adalah Nexus S yang dikeluarkan oleh produsen Samsung",
            "Android Honeycomb rilis pada Februari 2011, kemudian upgrade ke versi 3.1 dan 3.2.",
            "Android ini rilis pada 19 October 2011. Yang baru dalam android ini adalah perubahan interface dari android sebelumnya",
            "Android 4.1 Jelly Bean diumumkan pada 27 Juni 2012 pada konferensi Google l/O yang secara resmi dikenalkan ke publik sekitar Oktober 2012",
            "pada tanggal oktober 2013 google merilis kitkat sebagai generasi android berikutnya",
            "Android 5.0 merupakan versi paling baru dari sistem operasi android, Android 5.0 sendiri dianggap membawa update yang fantastis"};
    @Override

    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.list_fragment, container, false);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, AndroidOS);
        setListAdapter(adapter);

        return view;

    }
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        TextFragmentActivity txt = (TextFragmentActivity)getFragmentManager().findFragmentById(R.id.fragment2);
        txt.change(AndroidOS[position],"Version : "+Version[position],Description[position]);
        getListView().setSelector(android.R.color.holo_blue_dark);
    }
}
