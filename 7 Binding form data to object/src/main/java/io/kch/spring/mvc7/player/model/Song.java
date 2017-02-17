package io.kch.spring.mvc7.player.model;

//TODO: convert me to Java Bean!
public class Song {
    private final String artist;
    private final String album;
    private final String title;

    //TODO: you may leave that constructor, but do not forget to add a default one
    public Song(String artist, String album, String title) {
        this.artist = artist;
        this.album = album;
        this.title = title;
    }

    public String artist() {
        return artist;
    }

    public String album() {
        return album;
    }

    public String name() {
        return title;
    }

    @Override
    public String toString() {
        return artist + ": " + album + ": " + title;
    }
}
