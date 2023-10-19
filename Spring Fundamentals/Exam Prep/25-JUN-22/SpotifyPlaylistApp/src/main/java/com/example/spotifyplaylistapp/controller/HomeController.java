package com.example.spotifyplaylistapp.controller;

import com.example.spotifyplaylistapp.model.dto.HomeDisplayDTO;
import com.example.spotifyplaylistapp.service.LoggedUser;
import com.example.spotifyplaylistapp.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {

    private LoggedUser loggedUser;

    private SongService songService;

    @Autowired
    public HomeController(LoggedUser loggedUser, SongService songService) {
        this.loggedUser = loggedUser;
        this.songService = songService;
    }

    @GetMapping
    public String getIndex(){
        if(loggedUser.isLogged()){
            return "redirect:/home";
        }

        return "index";
    }

    @GetMapping("home")
    public ModelAndView getHome(ModelAndView mav){
        if(!loggedUser.isLogged()){
            mav.setViewName("redirect:/login");
            return mav;
        }

        mav.addObject("homeDisplayDTO", songService.getHomeDisplay());

        mav.setViewName("home");
        return mav;
    }
}
