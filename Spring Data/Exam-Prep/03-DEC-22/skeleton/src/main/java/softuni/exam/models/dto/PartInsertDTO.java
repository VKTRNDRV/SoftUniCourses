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


    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
