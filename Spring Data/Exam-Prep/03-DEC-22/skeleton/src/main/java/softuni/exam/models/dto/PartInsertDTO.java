package softuni.exam.models.dto;


import com.google.gson.annotations.Expose;

public class PartInsertDTO {

    @Expose
    private String partName;

    @Expose
    private Double price;

    @Expose
    private Integer quantity;

    //TODO: validation in setters (except UNIQUE - validate in service)
}
