package io.kch.spring.mvc13.player.model;

import java.util.List;

public class Songs {
    private List<Song> songs;
    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public List<Song> getSongs() {
        return songs;
    }
}
