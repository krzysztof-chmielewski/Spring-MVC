package io.kch.spring.mvc10.player.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

public class Song {
    @Size(max = 20, message = "{validation.song.artist.size}")
    @NotEmpty
    private String artist;

    @NotEmpty(message = "{validation.song.album.notEmpty}")
    private String album;

    @NotEmpty
    @Size(min = 3, max = 30)
    private String title;

    public Song(String artist, String album, String title) {
        this.artist = artist;
        this.album = album;
        this.title = title;
    }

    public Song() {
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return artist + ": " + album + ": " + title;
    }
}
