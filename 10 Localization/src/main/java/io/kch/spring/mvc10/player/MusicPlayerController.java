package io.kch.spring.mvc10.player;

import io.kch.spring.mvc10.player.model.MusicPlayer;
import io.kch.spring.mvc10.player.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
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
    //TODO do you see how Locale is obtained? Just passed as another method param
    public String index(Model model, Locale locale) {
        //TODO: notice how message is obtained
        model.addAttribute("message", messageSource.getMessage("music.player.currently.playing", null, locale));
        model.addAttribute("song", musicPlayer.currentSong());

        return "index";
    }

    @RequestMapping(path = "firstSong")
    public String firstSong(Model model) {
        //TODO: try to get message here in the same way like in index() method
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
