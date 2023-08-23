package com.example.mobilelele.web.controllers;

import com.example.mobilelele.models.dtos.UserLoginFormDto;
import com.example.mobilelele.models.dtos.UserRegisterFormDto;
import com.example.mobilelele.services.user.UserService;
import com.example.mobilelele.services.userRole.UserRoleService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController extends BaseController{

    private UserRoleService roleService;

    private UserService userService;

    @Autowired
    public UserController(UserRoleService roleRepository, UserService userService) {
        this.roleService = roleRepository;
        this.userService = userService;
    }

    @GetMapping("/register")
    public String getRegister(){
        return "auth-register";
    }


    @PostMapping("/register")
    public ModelAndView postRegister(@Valid @ModelAttribute UserRegisterFormDto userRegisterFormDto,
                                     BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return super.redirect("/users/register");
        }

        this.userService.registerUser(userRegisterFormDto);

        return super.redirect("/users/login");
    }


    @GetMapping("/login")
    public String getLogin(){
        return "auth-login";
    }

    @PostMapping("/login")
    public ModelAndView postLogin(@Valid @ModelAttribute UserLoginFormDto loginDTO,
                                  BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return super.redirect("users/login");
        }

        return super.redirect("/");
    }
}
