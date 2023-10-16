package com.example.battleships.domain.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "ships")
public class Ship extends BaseEntity{

    @Column(nullable = false,
            unique = true)
    private String name;

    @Column(nullable = false)
    private Long health;

    @Column(nullable = false)
    private Long power;

    @Column
    private LocalDate created;

    @ManyToOne
    @JoinColumn(nullable = false, name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(nullable = false, name = "user_id")
    private User user;



    public String getName() {
        return name;
    }

    public Ship setName(String name) {
        this.name = name;
        return this;
    }

    public Long getHealth() {
        return health;
    }

    public Ship setHealth(Long health) {
        this.health = health;
        return this;
    }

    public Long getPower() {
        return power;
    }

    public Ship setPower(Long power) {
        this.power = power;
        return this;
    }

    public LocalDate getCreated() {
        return created;
    }

    public Ship setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public Ship setCategory(Category category) {
        this.category = category;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Ship setUser(User user) {
        this.user = user;
        return this;
    }

    @Override
    public String toString() {
        String s = "| %s | %s | %s |";
        return String.format(s, name, health, power);

    }
}
