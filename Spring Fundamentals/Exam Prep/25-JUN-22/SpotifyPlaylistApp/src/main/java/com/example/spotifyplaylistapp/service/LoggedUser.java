package com.example.spotifyplaylistapp.service;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class LoggedUser {

    private String username;

    public String getUsername() {
        return username;
    }

    public LoggedUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public boolean isLogged(){
        return this.username != null;
    }

    public void logout(){
        this.username = null;
    }

    public void login(String username){
        this.username = username;
    }
}
