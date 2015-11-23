package com.example.nuriskandarz.praktikum_10;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Nur Iskandar Z on 22/11/2015.
 */
public class SongAdapter extends BaseAdapter {
    //daftar lagu dan layout
    private ArrayList<Song> songs;
    private LayoutInflater songInf;

    //constructor
    public SongAdapter(Context c, ArrayList<Song> theSongs){
        songs=theSongs;
        songInf=LayoutInflater.from(c);
    }

    @Override
    public int getCount() {
        return songs.size();
    }

    @Override
    public Object getItem(int arg0) {
        return null;
    }

    @Override
    public long getItemId(int arg0) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //memetakan susunan lagu
        LinearLayout songLay = (LinearLayout)songInf.inflate
                (R.layout.song, parent, false);
        //mengambil tampilan judul dan artistnya
        TextView songView = (TextView)songLay.findViewById(R.id.song_title);
        TextView artistView = (TextView)songLay.findViewById(R.id.song_artist);
        //mengambil lagu berdasarkan posisi
        Song currSong = songs.get(position);
        //mengambil kalimat judul dan artistnya
        songView.setText(currSong.getTitle());
        artistView.setText(currSong.getArtist());
        //mengatur posisi sebagai tanda
        songLay.setTag(position);
        return songLay;
    }

}