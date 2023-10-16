package com.example.battleships.service;

import com.example.battleships.domain.dto.*;
import com.example.battleships.domain.entity.Ship;
import com.example.battleships.domain.helper.LoggedUser;
import com.example.battleships.repository.ShipRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipService {

    private ShipRepository shipRepository;

    private ModelMapper modelMapper;
    private UserService userService;
    private LoggedUser loggedUser;
    private CategoryService categoryService;

    @Autowired
    public ShipService(ShipRepository shipRepository, ModelMapper modelMapper, UserService userService, LoggedUser loggedUser, CategoryService categoryService) {
        this.shipRepository = shipRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.loggedUser = loggedUser;
        this.categoryService = categoryService;
    }

    public void fight(BattleShipsModel battleShipsModel) {
        Ship loggedShip = this.shipRepository.findById(battleShipsModel.getLoggedUserShip()).orElseThrow();
        Ship notLoggedShip = this.shipRepository.findById(battleShipsModel.getNotLoggedUserShip()).orElseThrow();

        notLoggedShip.setHealth(notLoggedShip.getHealth() - loggedShip.getPower());

        if (notLoggedShip.getHealth() <= 0) {
            this.shipRepository.deleteById(battleShipsModel.getNotLoggedUserShip());
        } else {
            this.shipRepository.saveAndFlush(notLoggedShip);
        }
    }

    public List<ShipModel> findAllByUserId(Long id) {
        return this.shipRepository.findAllByUserId(id)
                .orElseThrow()
                .stream()
                .map(ship -> this.modelMapper.map(ship, ShipModel.class))
                .toList();
    }

    public void addShip(ShipAddModel addModel) {
        UserModel userModel = this.userService.findById(this.loggedUser.getId());
        CategoryModel categoryModel = this.categoryService.findByName(addModel.getCategory());

        Ship shipToSave = this.modelMapper.map(new ShipModel()
                        .setCategory(categoryModel)
                        .setCreated(addModel.getCreated())
                        .setName(addModel.getName())
                        .setHealth(addModel.getHealth())
                        .setPower(addModel.getPower())
                        .setUser(userModel),
                Ship.class);

        this.shipRepository.saveAndFlush(shipToSave);
    }
}
