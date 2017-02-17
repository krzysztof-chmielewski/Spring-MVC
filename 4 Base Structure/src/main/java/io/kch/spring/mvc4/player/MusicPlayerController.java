package io.kch.spring.mvc4.player;

import io.kch.spring.mvc4.player.model.MusicPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MusicPlayerController {
    private final MusicPlayer musicPlayer;

    @Autowired
    public MusicPlayerController(MusicPlayer musicPlayer) {
        this.musicPlayer = musicPlayer;
    }

    @RequestMapping
    public String index(Model model) {
        model.addAttribute("message", "Currently playing");
        model.addAttribute("song", musicPlayer.currentSong());

        return "index";
    }

    @RequestMapping(path = "firstSong")
    public String firstSong(Model model) {
        //TODO: implement me!
        return null;
    }
}
