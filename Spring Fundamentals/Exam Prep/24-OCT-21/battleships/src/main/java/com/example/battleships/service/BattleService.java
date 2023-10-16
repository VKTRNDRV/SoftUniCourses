package com.example.battleships.service;

import com.example.battleships.domain.dto.ShipModel;
import com.example.battleships.domain.dto.UserModel;
import com.example.battleships.domain.dto.UserWithShipsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BattleService {
    private final UserService userService;
    private final ShipService shipService;

    @Autowired
    public BattleService(UserService userService, ShipService shipService) {
        this.userService = userService;
        this.shipService = shipService;
    }


    public UserWithShipsModel getUserWithShips(Long id) {
        UserModel userModel = this.userService.findById(id);
        List<ShipModel> allByUserId = this.shipService.findAllByUserId(id);

        return new UserWithShipsModel()
                .setUserModel(userModel)
                .setShipModels(allByUserId);
    }

}
