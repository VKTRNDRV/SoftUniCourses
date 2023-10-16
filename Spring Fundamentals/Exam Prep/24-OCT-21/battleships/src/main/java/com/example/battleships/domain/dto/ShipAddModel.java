package com.example.battleships.domain.dto;

import com.example.battleships.domain.enums.CategoryName;
import com.example.battleships.validations.ValidateExistenceOfShip;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class ShipAddModel {
    @NotNull
    @Size(min = 2, max = 10)
    @ValidateExistenceOfShip
    private String name;

    @NotNull
    @Positive
    private Long health;

    @NotNull
    @Positive
    private Long power;

    @NotNull
    @PastOrPresent
    private LocalDate created;

    @NotNull
    private CategoryName category;



    public String getName() {
        return name;
    }

    public ShipAddModel setName(String name) {
        this.name = name;
        return this;
    }

    public Long getHealth() {
        return health;
    }

    public ShipAddModel setHealth(Long health) {
        this.health = health;
        return this;
    }

    public Long getPower() {
        return power;
    }

    public ShipAddModel setPower(Long power) {
        this.power = power;
        return this;
    }

    public LocalDate getCreated() {
        return created;
    }

    public ShipAddModel setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public CategoryName getCategory() {
        return category;
    }

    public ShipAddModel setCategory(CategoryName category) {
        this.category = category;
        return this;
    }
}
