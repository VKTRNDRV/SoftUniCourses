package com.dictionaryapp.controller;

import com.dictionaryapp.model.dto.word.WordAddDTO;
import com.dictionaryapp.service.LoggedUser;
import com.dictionaryapp.service.WordService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/words")
public class WordController {

    private LoggedUser loggedUser;

    private WordService wordService;

    @Autowired
    public WordController(LoggedUser loggedUser, WordService wordService) {
        this.loggedUser = loggedUser;
        this.wordService = wordService;
    }

    @GetMapping("/add")
    public ModelAndView getAddWord(@ModelAttribute(name = "wordAddDTO")
                                       WordAddDTO wordAddDTO,
                                   ModelAndView modelAndView){
        if(!loggedUser.isLoggedIn()){
            modelAndView.setViewName("redirect:/login");
            return modelAndView;
        }

        modelAndView.setViewName("word-add");
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView postAddWord(@Valid @ModelAttribute(name = "wordAddDTO")
                                        WordAddDTO wordAddDTO,
                                    BindingResult bindingResult,
                                    ModelAndView modelAndView){
        if(!loggedUser.isLoggedIn()){
            modelAndView.setViewName("redirect:/login");
            return modelAndView;
        }

        if(bindingResult.hasErrors()){
            modelAndView.setViewName("word-add");
            return modelAndView;
        }

        this.wordService.addWord(wordAddDTO);

        modelAndView.setViewName("redirect:/home");
        return modelAndView;
    }

    @PostMapping("/remove-all")
    public ModelAndView postRemoveAll(ModelAndView modelAndView){
        if(!loggedUser.isLoggedIn()){
            modelAndView.setViewName("redirect:/login");
            return modelAndView;
        }

        this.wordService.removeAllWords();
        modelAndView.setViewName("redirect:/home");
        return modelAndView;
    }

    @PostMapping("/remove/{id}")
    public ModelAndView postRemoveById(@PathVariable Long id,
                                       ModelAndView modelAndView){
        if(!loggedUser.isLoggedIn()){
            modelAndView.setViewName("redirect:/login");
            return modelAndView;
        }

        this.wordService.removeWordById(id);

        modelAndView.setViewName("redirect:/home");
        return modelAndView;
    }
}
