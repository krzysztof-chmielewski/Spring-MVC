package io.kch.spring.mvc5.player;

import io.kch.spring.mvc5.player.model.MusicPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MusicPlayerController {
    private final MusicPlayer musicPlayer;

    @Autowired
    public MusicPlayerController(MusicPlayer musicPlayer) {
        this.musicPlayer = musicPlayer;
    }

    @RequestMapping(path = {"", "home"})
    public String index(Model model) {
        model.addAttribute("message", "Currently playing");
        model.addAttribute("song", musicPlayer.currentSong());

        return "index";
    }

    @RequestMapping(path = "firstSong")
    public String firstSong(Model model) {
        model.addAttribute("message", "The very first song ever played was");
        model.addAttribute("song", musicPlayer.playedSongs().get(0));

        return "index";
    }

    @RequestMapping(path = "playSong", params = {"artist", "album", "title"})
    public String playSong(@RequestParam String artist,
                           @RequestParam String album,
                           @RequestParam String title) {
        //TODO: play song for the music player

        return "redirect:home";
    }
}
