package com.example.spotifyplaylistapp.controller;

import com.example.spotifyplaylistapp.model.dto.UserLoginDTO;
import com.example.spotifyplaylistapp.model.dto.UserRegisterDTO;
import com.example.spotifyplaylistapp.service.LoggedUser;
import com.example.spotifyplaylistapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class AuthController {

    private LoggedUser loggedUser;

    private UserService userService;

    @Autowired
    public AuthController(LoggedUser loggedUser, UserService userService) {
        this.loggedUser = loggedUser;
        this.userService = userService;
    }

    @GetMapping("/register")
    public ModelAndView getRegister(@ModelAttribute(name = "userRegisterDTO")
                                        UserRegisterDTO registerDTO){
        if(loggedUser.isLogged()){
            return new ModelAndView("redirect:/home");
        }

        return new ModelAndView("register");
    }

    @PostMapping("/register")
    public ModelAndView register(@Valid @ModelAttribute(name = "userRegisterDTO")
                                     UserRegisterDTO registerDTO,
                                 BindingResult bindingResult, ModelAndView mav){
        if(loggedUser.isLogged()){
            mav.setViewName("redirect:/home");
            return mav;
        }

        if(bindingResult.hasErrors()){
            mav.setViewName("register");
            return mav;
        }

        this.userService.registerUser(registerDTO);

        mav.setViewName("redirect:/login");
        return mav;
    }

    @GetMapping("/login")
    public ModelAndView getLogin(@ModelAttribute(name = "userLoginDTO")
                                     UserLoginDTO userLoginDTO,
                                 ModelAndView mav){
        if(loggedUser.isLogged()){
            mav.setViewName("redirect:/home");
            return mav;
        }

        mav.setViewName("login");
        return mav;
    }

    @PostMapping("/login")
    public ModelAndView login(@Valid @ModelAttribute(name = "userLoginDTO")
                                  UserLoginDTO userLoginDTO,
                              BindingResult bindingResult,
                              ModelAndView mav){

        if(loggedUser.isLogged()){
            mav.setViewName("redirect:/home");
            return mav;
        }

        if(bindingResult.hasErrors()){
            mav.setViewName("login");
            return mav;
        }

        boolean isLoggedIn = this.userService.login(userLoginDTO);

        if(!isLoggedIn){
            mav.addObject("failedLogin", true);
            mav.setViewName("login");
            return mav;
        }

        mav.setViewName("redirect:/home");
        return mav;
    }

    @PostMapping("logout")
    public ModelAndView logout(ModelAndView mav){
        this.loggedUser.logout();

        mav.setViewName("redirect:/");
        return mav;
    }
}
