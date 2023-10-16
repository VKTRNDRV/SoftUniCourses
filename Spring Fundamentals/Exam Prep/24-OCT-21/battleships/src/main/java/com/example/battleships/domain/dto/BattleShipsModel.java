package com.example.battleships.domain.dto;

public class BattleShipsModel {
    private Long loggedUserShip;
    private Long notLoggedUserShip;


    public Long getLoggedUserShip() {
        return loggedUserShip;
    }

    public BattleShipsModel setLoggedUserShip(Long loggedUserShip) {
        this.loggedUserShip = loggedUserShip;
        return this;
    }

    public Long getNotLoggedUserShip() {
        return notLoggedUserShip;
    }

    public BattleShipsModel setNotLoggedUserShip(Long notLoggedUserShip) {
        this.notLoggedUserShip = notLoggedUserShip;
        return this;
    }
}
