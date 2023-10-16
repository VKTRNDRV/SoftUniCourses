package com.example.battleships.domain.dto;

import com.example.battleships.domain.enums.CategoryName;

import java.time.LocalDate;

public class ShipModel {
    private Long id;
    private String name;
    private Long health;
    private Long power;
    private LocalDate created;
    private CategoryModel category;
    private UserModel user;



    public Long getId() {
        return id;
    }

    public ShipModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ShipModel setName(String name) {
        this.name = name;
        return this;
    }

    public Long getHealth() {
        return health;
    }

    public ShipModel setHealth(Long health) {
        this.health = health;
        return this;
    }

    public Long getPower() {
        return power;
    }

    public ShipModel setPower(Long power) {
        this.power = power;
        return this;
    }

    public LocalDate getCreated() {
        return created;
    }

    public ShipModel setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public CategoryModel getCategory() {
        return category;
    }

    public ShipModel setCategory(CategoryModel category) {
        this.category = category;
        return this;
    }

    public UserModel getUser() {
        return user;
    }

    public ShipModel setUser(UserModel user) {
        this.user = user;
        return this;
    }
}
