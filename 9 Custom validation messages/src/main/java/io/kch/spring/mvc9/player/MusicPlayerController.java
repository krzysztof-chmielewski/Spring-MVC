package io.kch.spring.mvc9.player;

import io.kch.spring.mvc9.player.model.MusicPlayer;
import io.kch.spring.mvc9.player.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

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

    @RequestMapping(path = "playSong", method = RequestMethod.POST)
    public String playSong(@Valid Song song, Errors errors)  {
        if (errors.hasErrors()) {
            return "playSong";
        }
        musicPlayer.playSong(song);

        return "redirect:home";
    }

    @RequestMapping(path = "playSong", method = RequestMethod.GET)
    public String playSongForm() {
        return "playSong";
    }
}
