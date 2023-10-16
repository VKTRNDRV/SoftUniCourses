package com.example.battleships.domain.dto;

import java.util.List;

public class UserWithShipsModel {

    private UserModel userModel;
    private List<ShipModel> shipModels;


    public UserModel getUserModel() {
        return userModel;
    }

    public UserWithShipsModel setUserModel(UserModel userModel) {
        this.userModel = userModel;
        return this;
    }

    public List<ShipModel> getShipModels() {
        return shipModels;
    }

    public UserWithShipsModel setShipModels(List<ShipModel> shipModels) {
        this.shipModels = shipModels;
        return this;
    }
}
