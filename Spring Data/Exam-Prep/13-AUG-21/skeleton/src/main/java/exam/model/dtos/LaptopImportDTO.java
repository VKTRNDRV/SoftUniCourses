package exam.model.dtos;

import com.google.gson.annotations.Expose;
import exam.model.enums.WarrantyType;

import javax.validation.constraints.*;

public class LaptopImportDTO {

    @Expose
    // UNIQUE
    @NotNull
    @Size(min = 9)
    private String macAddress;

    @Expose
    @NotNull
    @Positive
    private Double cpuSpeed;

    @Expose
    @NotNull
    @Min(value = 8)
    @Max(value = 128)
    private Integer ram;

    @Expose
    @NotNull
    @Min(value = 128)
    @Max(value = 1024)
    private Integer storage;

    @Expose
    @NotNull
    @Size(min = 10)
    private String description;

    @Expose
    @NotNull
    @Positive
    private Double price;

    @Expose
    @NotNull
    private WarrantyType warrantyType;

    @Expose
    @NotNull
    private ShopNameDTO shop;

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public Double getCpuSpeed() {
        return cpuSpeed;
    }

    public void setCpuSpeed(Double cpuSpeed) {
        this.cpuSpeed = cpuSpeed;
    }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public Integer getStorage() {
        return storage;
    }

    public void setStorage(Integer storage) {
        this.storage = storage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public WarrantyType getWarrantyType() {
        return warrantyType;
    }

    public void setWarrantyType(WarrantyType warrantyType) {
        this.warrantyType = warrantyType;
    }

    public ShopNameDTO getShop() {
        return shop;
    }

    public void setShop(ShopNameDTO shop) {
        this.shop = shop;
    }
}
