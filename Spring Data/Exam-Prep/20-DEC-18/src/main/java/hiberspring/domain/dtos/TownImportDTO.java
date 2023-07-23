package hiberspring.domain.dtos;

import com.google.gson.annotations.Expose;

public class TownImportDTO {

    @Expose
    private String name;

    @Expose
    private Integer population;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public boolean containsInvalidNulls(){
        return name == null || population == null;
    }
}
