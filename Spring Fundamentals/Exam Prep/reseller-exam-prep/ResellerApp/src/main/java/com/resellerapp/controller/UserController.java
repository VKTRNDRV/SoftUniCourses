package com.resellerapp.controller;

import com.resellerapp.model.dto.UserLoginBindingModel;
import com.resellerapp.model.dto.UserRegisterBindingModel;
import com.resellerapp.service.LoggedUser;
import com.resellerapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserController {

    private final UserService userService;
    private final LoggedUser loggedUser;

    @Autowired
    public UserController(UserService userService, LoggedUser loggedUser) {
        this.userService = userService;
        this.loggedUser = loggedUser;
    }

    @GetMapping("/login")
    public ModelAndView login() {
        if (loggedUser.isLogged()) {
            return new ModelAndView("redirect:/home");
        }

        return new ModelAndView("login");
    }

    @PostMapping("/login")
    public String login(
            @Valid @ModelAttribute("userLoginBindingModel") UserLoginBindingModel userLoginBindingModel,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {
        if (loggedUser.isLogged()) {
            return "redirect:/home";
        }

        boolean hasErrors = bindingResult.hasErrors();

        if (hasErrors) {
            redirectAttributes.addFlashAttribute(
                    "userLoginBindingModel",
                    userLoginBindingModel);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.userLoginBindingModel",
                    bindingResult);

            return "redirect:/login";
        }

        boolean isLogged = userService.login(userLoginBindingModel);

        if(!isLogged){
            redirectAttributes.addFlashAttribute(
                    "userLoginBindingModel",
                    userLoginBindingModel);
            bindingResult.rejectValue("password", "1");
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.userLoginBindingModel",
                    bindingResult);

            return "redirect:/login";
        }

        return "redirect:/home";
    }

    @GetMapping("/register")
    public String register() {
        if (loggedUser.isLogged()) {
            return "redirect:/home";
        }

        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute(name = "userRegisterBindingModel")
                               UserRegisterBindingModel userRegisterBindingModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
        if (loggedUser.isLogged()) {
            return "redirect:/home";
        }

        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("userRegisterBindingModel",
                    userRegisterBindingModel);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.userRegisterBindingModel",
                    bindingResult);
            return "redirect:/register";
        }

        boolean isRegistered = userService.register(userRegisterBindingModel);

        String view = isRegistered ? "redirect:/login" : "redirect:/register";

        return view;
    }

    @GetMapping("/logout")
    public ModelAndView logout() {
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/home");
        }

        userService.logout();
        return new ModelAndView("redirect:/");
    }


    @ModelAttribute(name = "userRegisterBindingModel")
    public UserRegisterBindingModel userRegisterBindingModel() {
        return new UserRegisterBindingModel();
    }

    @ModelAttribute(name = "userLoginBindingModel")
    public UserLoginBindingModel userLoginBindingModel() {
        return new UserLoginBindingModel();
    }
}
