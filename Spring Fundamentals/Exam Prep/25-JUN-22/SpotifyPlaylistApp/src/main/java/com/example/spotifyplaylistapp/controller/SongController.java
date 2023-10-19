package com.example.spotifyplaylistapp.controller;

import com.example.spotifyplaylistapp.model.dto.SongAddDTO;
import com.example.spotifyplaylistapp.service.LoggedUser;
import com.example.spotifyplaylistapp.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/songs")
public class SongController {

    private LoggedUser loggedUser;

    private SongService songService;

    @Autowired
    public SongController(LoggedUser loggedUser, SongService songService) {
        this.loggedUser = loggedUser;
        this.songService = songService;
    }

    @GetMapping("/add")
    public ModelAndView getAddSong(@ModelAttribute(name = "songAddDTO")
                                       SongAddDTO songAddDTO,
                                   ModelAndView mav){
        if(!loggedUser.isLogged()){
            mav.setViewName("redirect:/login");
            return mav;
        }

        mav.setViewName("song-add");
        return mav;
    }

    @PostMapping("/add")
    public ModelAndView addSong(@Valid @ModelAttribute(name = "songAddDTO")
                                    SongAddDTO songAddDTO,
                                BindingResult bindingResult,
                                ModelAndView mav){
        if(!loggedUser.isLogged()){
            mav.setViewName("redirect:/login");
            return mav;
        }

        if(bindingResult.hasErrors()){
            mav.setViewName("song-add");
            return mav;
        }

        this.songService.addSong(songAddDTO);

        mav.setViewName("redirect:/home");
        return mav;
    }

    @PostMapping("/remove-all")
    public ModelAndView removeAll(ModelAndView mav){
        if(!loggedUser.isLogged()){
            mav.setViewName("redirect:/login");
            return mav;
        }

        this.songService.clearPlaylist();

        mav.setViewName("redirect:/home");
        return mav;
    }

    @PostMapping("/add/{id}")
    public ModelAndView addToPlaylist(@PathVariable Long id, ModelAndView mav){
        if(!loggedUser.isLogged()){
            mav.setViewName("redirect:/login");
            return mav;
        }

        this.songService.addSongToPlaylist(id);
        mav.setViewName("redirect:/home");
        return mav;
    }
}
