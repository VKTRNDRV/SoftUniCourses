package hiberspring.domain.dtos;

import com.google.gson.annotations.Expose;

public class BranchImportDTO {

    @Expose
    private String name;
    @Expose
    private String town;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }


    public boolean containsInvalidNulls(){
        return name == null || town == null;
    }

}
