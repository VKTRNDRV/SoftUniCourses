package hiberspring.domain.dtos;

import com.google.gson.annotations.Expose;

public class EmployeeCardImportDTO {

    @Expose
    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean containsInvalidNulls(){
        return number == null;
    }
}
