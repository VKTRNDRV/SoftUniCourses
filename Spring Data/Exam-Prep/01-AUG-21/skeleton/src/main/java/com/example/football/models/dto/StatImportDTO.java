package com.example.football.models.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "stat")
@XmlAccessorType(value = XmlAccessType.NONE)
public class StatImportDTO {

    @XmlElement
    // COMPOSITE UNIQUE
    @NotNull
    @Positive
    private float passing;

    @XmlElement
    // COMPOSITE UNIQUE
    @NotNull
    @Positive
    private float shooting;

    @XmlElement
    // COMPOSITE UNIQUE
    @NotNull
    @Positive
    private float endurance;


    public float getPassing() {
        return passing;
    }

    public void setPassing(float passing) {
        this.passing = passing;
    }

    public float getShooting() {
        return shooting;
    }

    public void setShooting(float shooting) {
        this.shooting = shooting;
    }

    public float getEndurance() {
        return endurance;
    }

    public void setEndurance(float endurance) {
        this.endurance = endurance;
    }
}
