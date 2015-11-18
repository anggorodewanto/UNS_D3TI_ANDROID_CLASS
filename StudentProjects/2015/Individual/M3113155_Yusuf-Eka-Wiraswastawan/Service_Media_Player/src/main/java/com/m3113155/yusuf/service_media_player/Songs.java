package com.m3113155.yusuf.service_media_player;

/**
 * Created by Yusuf on 11/17/2015.
 */
public class Songs {

    private long id;
    private String title;
    private String artist;

    public Song(long songID, String songTitle, String songArtist) {
        id=songID;
        title=songTitle;
        artist=songArtist;
    }

    public long getID(){return id;}
    public String getTitle(){return title;}
    public String getArtist(){return artist;}
}
