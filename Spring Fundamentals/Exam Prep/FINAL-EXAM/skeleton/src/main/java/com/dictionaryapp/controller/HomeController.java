package com.dictionaryapp.controller;

import com.dictionaryapp.service.LoggedUser;
import com.dictionaryapp.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class HomeController {

    private LoggedUser loggedUser;

    private WordService wordService;

    @Autowired
    public HomeController(LoggedUser loggedUser, WordService wordService) {
        this.loggedUser = loggedUser;
        this.wordService = wordService;
    }

    @GetMapping("/")
    public ModelAndView getIndex(ModelAndView modelAndView){
        if(loggedUser.isLoggedIn()){
            modelAndView.setViewName("redirect:/home");
        }

        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping("/home")
    public ModelAndView getHome(ModelAndView modelAndView){
        if(!loggedUser.isLoggedIn()){
            modelAndView.setViewName("redirect:/login");
            return modelAndView;
        }

        modelAndView.addObject("homeDisplayDTO",
                this.wordService.getHomeDisplay());

        modelAndView.setViewName("home");
        return modelAndView;
    }
}
