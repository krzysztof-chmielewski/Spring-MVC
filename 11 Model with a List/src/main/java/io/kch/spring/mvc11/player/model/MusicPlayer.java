package io.kch.spring.mvc11.player.model;

import java.util.List;

public interface MusicPlayer {
    void playSong(Song song);

    Song currentSong();

    List<Song> playedSongs();
}
