package com.example.mobilelele.web.controllers;

import com.example.mobilelele.models.dtos.UserRoleViewDto;
import com.example.mobilelele.services.userRole.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController extends BaseController{

    private UserRoleService roleService;

    @Autowired
    public UserController(UserRoleService roleRepository) {
        this.roleService = roleRepository;
    }

    @GetMapping("/register")
    public String getRegister(){
        return "auth-register";
    }


    @PostMapping("/register")
    public ModelAndView postRegister(){
        return super.redirect("auth-login");
    }


    @GetMapping("/login")
    public String getLogin(){
        return "auth-login";
    }
}
