package com.example.football.models.dto;

import com.example.football.models.enums.Position;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@XmlRootElement(name = "player")
@XmlAccessorType(value = XmlAccessType.NONE)
public class PlayerImportDTO {

    @XmlElement(name = "first-name")
    @NotNull
    @Size(min = 3)
    private String firstName;

    @XmlElement(name = "last-name")
    @NotNull
    @Size(min = 3)
    private String lastName;

    @XmlElement
    // UNIQUE
    @NotNull
    @Email
    private String email;

    @XmlElement(name = "birth-date")
    @NotNull
    private String birthDate;

    @XmlElement
    @NotNull
    private Position position;

    @XmlElement
    @NotNull
    private TownNameDTO town;

    @XmlElement
    @NotNull
    private TeamNameDTO team;

    @XmlElement
    @NotNull
    private StatIdDTO stat;



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

    public String getBirthDate() {
        return birthDate;
    }

    public LocalDate getBirthDateAsLocalDate(){
        return LocalDate.parse(birthDate,
                DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public TownNameDTO getTown() {
        return town;
    }

    public void setTown(TownNameDTO town) {
        this.town = town;
    }

    public TeamNameDTO getTeam() {
        return team;
    }

    public void setTeam(TeamNameDTO team) {
        this.team = team;
    }

    public StatIdDTO getStat() {
        return stat;
    }

    public void setStat(StatIdDTO stat) {
        this.stat = stat;
    }
}
