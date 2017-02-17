package io.kch.spring.mvc5.player.model;

public class Song {
    private final String artist;
    private final String album;
    private final String title;

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
