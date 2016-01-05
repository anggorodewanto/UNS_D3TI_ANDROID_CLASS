package com.example.galaxy.tugaskelompok8;

    /**
     * Created by user on 14/11/2015.
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

        public long getID(){return id;}
        public String getTitle(){return title;}
        public String getArtist(){return artist;}

    }

