package io.kch.spring.mvc13.player;

import io.kch.spring.mvc13.player.model.MusicPlayer;
import io.kch.spring.mvc13.player.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/song")
public class SongController {
    private final MusicPlayer musicPlayer;

    @Autowired
    public SongController(MusicPlayer musicPlayer) {
        this.musicPlayer = musicPlayer;
    }

    @GetMapping(path = "get/{index}")
    public Song get(@PathVariable("index") Integer index) {
        return musicPlayer.playedSongs().get(index);
    }

    @PostMapping(path = "create")
    public void create(Song song) {
        musicPlayer.playSong(song);
    }
}
