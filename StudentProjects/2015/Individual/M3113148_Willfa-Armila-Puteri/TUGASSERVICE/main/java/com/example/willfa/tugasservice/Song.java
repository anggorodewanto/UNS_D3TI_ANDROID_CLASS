package com.example.willfa.tugasservice;

/**
 * Created by willfa on 19/11/2015.
 */
public class Song {
    private long id;
    private String title;
    private String artist;

    public Song(long songID, String songTitle, String songArtist){
        id=songID;
        title=songTitle;
        artist=songArtist;
    }

    public long getId(){return id;}
    public String getTitle(){return title;}
    public String getArtist(){return artist;}
}
