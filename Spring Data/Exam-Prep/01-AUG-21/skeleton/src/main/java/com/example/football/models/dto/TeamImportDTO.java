package com.example.football.models.dto;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TeamImportDTO {

    @Expose
    // UNIQUE
    @NotNull
    @Size(min = 3)
    private String name;

    @Expose
    @NotNull
    @Size(min = 3)
    private String stadiumName;

    @Expose
    @NotNull
    @Min(value = 1000)
    private Integer fanBase;

    @Expose
    @NotNull
    @Size(min = 10)
    private String history;

    @Expose
    @NotNull
    @Size(min = 2)
    private String townName;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

    public Integer getFanBase() {
        return fanBase;
    }

    public void setFanBase(Integer fanBase) {
        this.fanBase = fanBase;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }
}
