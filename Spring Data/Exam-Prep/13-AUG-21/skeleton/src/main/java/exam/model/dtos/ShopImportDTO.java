package exam.model.dtos;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "shop")
@XmlAccessorType(value = XmlAccessType.NONE)
public class ShopImportDTO {

    @XmlElement
    @NotNull
    @Size(min = 4)
    private String address;

    @XmlElement(name = "employee-count")
    @NotNull
    @Min(value = 1)
    @Max(value = 50)
    private Integer employeeCount;

    @XmlElement
    @NotNull
    @Min(value = 20000)
    private BigDecimal income;

    @XmlElement
    //UNIQUE
    @NotNull
    @Size(min = 4)
    private String name;

    @XmlElement(name = "shop-area")
    @NotNull
    @Min(value = 150)
    private Integer shopArea;

    @XmlElement(name = "town")
    private TownNameImportDTO town;


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(Integer employeeCount) {
        this.employeeCount = employeeCount;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getShopArea() {
        return shopArea;
    }

    public void setShopArea(Integer shopArea) {
        this.shopArea = shopArea;
    }

    public TownNameImportDTO getTown() {
        return town;
    }

    public void setTown(TownNameImportDTO town) {
        this.town = town;
    }
}
