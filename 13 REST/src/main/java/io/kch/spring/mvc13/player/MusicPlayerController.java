package io.kch.spring.mvc13.player;

import io.kch.spring.mvc13.player.model.MusicPlayer;
import io.kch.spring.mvc13.player.model.Song;
import io.kch.spring.mvc13.player.model.Songs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Locale;

@Controller
public class MusicPlayerController {
    private final MusicPlayer musicPlayer;
    private final MessageSource messageSource;

    @Autowired
    public MusicPlayerController(MusicPlayer musicPlayer, MessageSource messageSource) {
        this.musicPlayer = musicPlayer;
        this.messageSource = messageSource;
    }

    @RequestMapping(path = {"", "home"})
    public String index(Model model, Locale locale) {
        model.addAttribute("message", messageSource.getMessage("music.player.currently.playing", null, locale));
        model.addAttribute("song", musicPlayer.currentSong());

        return "index";
    }

    @RequestMapping(path = "firstSong")
    public String firstSong(Model model, Locale locale) {
        model.addAttribute("message", messageSource.getMessage("music.player.first.song", null, locale));
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

    @RequestMapping(path = "playedSongs")
    public String listSongs(@ModelAttribute("songs") Songs songs) {
        songs.setSongs(musicPlayer.playedSongs());

        return "playedSongs";
    }
}
