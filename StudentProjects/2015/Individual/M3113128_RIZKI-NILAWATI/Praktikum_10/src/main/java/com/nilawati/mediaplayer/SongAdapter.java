package com.nilawati.mediaplayer;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Rizki Nilawati on 21/11/2015.
 */
public class SongAdapter extends BaseAdapter {
    private ArrayList<Song> songs;
    private LayoutInflater songInf;

    public SongAdapter(Context c, ArrayList<Song> theSongs){
        songs = theSongs;
        songInf = LayoutInflater.from(c);
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
        //map to song layout
        LinearLayout songLay = (LinearLayout)songInf.inflate (R.layout.song, parent, false);

        //get title and artist views
        TextView songView = (TextView)songLay.findViewById (R.id.song_title);
        TextView artistView = (TextView)songLay.findViewById (R.id.song_artist);

        //get song using position
        Song currentSong = songs.get(position);

        //get title and artist strings
        songView.setText(currentSong.getTitle());
        artistView.setText(currentSong.getArtist());

        //set position as tag
        songLay.setTag(position);
        return songLay;
    }
}
