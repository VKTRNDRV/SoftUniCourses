package com.example.battleships.domain.helper;

public class LoggedUser {

    private Long id;

    public boolean isLogged() {
        return !(this.id == null);
    }

    public void clearUser() {
        this.id = null;
    }

    public Long getId() {
        return id;
    }

    public LoggedUser setId(Long id) {
        this.id = id;
        return this;
    }
}