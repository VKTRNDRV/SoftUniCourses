package com.example.football.models.entity;

import com.example.football.models.enums.Position;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name",
            nullable = false)
    private String firstName;

    @Column(name = "last_name",
            nullable = false)
    private String lastName;

    @Column(nullable = false,
            unique = true)
    private String email;

    @Column(name = "birth_date",
            nullable = false)
    private LocalDate birthDate;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(nullable = false)
    private Position position;

    @ManyToOne
    @JoinColumn(name = "stat_id",
            nullable = false)
    private Stat stat;

    @ManyToOne
    @JoinColumn(name = "town_id",
            nullable = false)
    private Town town;


    @ManyToOne
    @JoinColumn(name = "team_id",
            nullable = false)
    private Team team;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Stat getStat() {
        return stat;
    }

    public void setStat(Stat stat) {
        this.stat = stat;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
