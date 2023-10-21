package com.dictionaryapp.controller;

import com.dictionaryapp.model.dto.user.UserLoginDTO;
import com.dictionaryapp.model.dto.user.UserRegisterDTO;
import com.dictionaryapp.service.LoggedUser;
import com.dictionaryapp.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class AuthController {

    private LoggedUser loggedUser;

    private UserService userService;

    @Autowired
    public AuthController(LoggedUser loggedUser, UserService userService) {
        this.loggedUser = loggedUser;
        this.userService = userService;
    }

    @GetMapping("/login")
    public ModelAndView getLogin(@ModelAttribute(name = "userLoginDTO")
                                     UserLoginDTO userLoginDTO,
                                 ModelAndView modelAndView){
        if(loggedUser.isLoggedIn()){
            modelAndView.setViewName("redirect:/home");
            return modelAndView;
        }

        modelAndView.setViewName("login");
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView postLogin(@Valid @ModelAttribute(name = "userLoginDTO")
                                      UserLoginDTO userLoginDTO,
                                  BindingResult bindingResult,
                                  ModelAndView modelAndView){
        if(loggedUser.isLoggedIn()){
            modelAndView.setViewName("redirect:/home");
            return modelAndView;
        }

        if(bindingResult.hasErrors()){
            modelAndView.setViewName("login");
            return modelAndView;
        }

        boolean isLoginSuccessful = this.userService.loginUser(userLoginDTO);
        if(!isLoginSuccessful){
            modelAndView.addObject("failedLogin", true);
            modelAndView.setViewName("login");
            return modelAndView;
        }

        modelAndView.setViewName("redirect:/home");
        return modelAndView;
    }

    @PostMapping("/logout")
    public ModelAndView postLogout(ModelAndView modelAndView){
        if(!loggedUser.isLoggedIn()){
            modelAndView.setViewName("redirect:/login");
            return modelAndView;
        }

        loggedUser.logout();
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }

    @GetMapping("/register")
    public ModelAndView getRegister(@ModelAttribute(name = "userRegisterDTO")
                                        UserRegisterDTO userRegisterDTO,
                                    ModelAndView modelAndView){
        if(loggedUser.isLoggedIn()){
            modelAndView.setViewName("redirect:/home");
            return modelAndView;
        }

        modelAndView.setViewName("register");
        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView postRegister(@Valid @ModelAttribute(name = "userRegisterDTO")
                                         UserRegisterDTO userRegisterDTO,
                                     BindingResult bindingResult,
                                     ModelAndView modelAndView){
        if(loggedUser.isLoggedIn()){
            modelAndView.setViewName("redirect:/home");
            return modelAndView;
        }

        if(bindingResult.hasErrors()){
            modelAndView.setViewName("register");
            return modelAndView;
        }

        if(!userRegisterDTO.arePasswordsMatching()){
            modelAndView.addObject("notMatchingPasswords", true);
            modelAndView.setViewName("register");
            return modelAndView;
        }

        this.userService.registerUser(userRegisterDTO);
        modelAndView.setViewName("redirect:/login");
        return modelAndView;
    }
}
