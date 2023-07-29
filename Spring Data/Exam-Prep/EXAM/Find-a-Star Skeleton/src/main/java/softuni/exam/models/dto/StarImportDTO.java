package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;
import softuni.exam.models.enums.StarType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class StarImportDTO {

    @Expose
    @NotNull
    @Size(min = 6)
    private String description;

    @Expose
    @NotNull
    @Positive
    private Double lightYears;

    @Expose
    // UNIQUE
    @NotNull
    @Size(min = 2, max = 30)
    private String name;

    @Expose
    @NotNull
    private StarType starType;

    @Expose
    @NotNull
    @Positive
    private Long constellation;



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getLightYears() {
        return lightYears;
    }

    public void setLightYears(Double lightYears) {
        this.lightYears = lightYears;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StarType getStarType() {
        return starType;
    }

    public void setStarType(StarType starType) {
        this.starType = starType;
    }

    public Long getConstellation() {
        return constellation;
    }

    public void setConstellation(Long constellation) {
        this.constellation = constellation;
    }
}
