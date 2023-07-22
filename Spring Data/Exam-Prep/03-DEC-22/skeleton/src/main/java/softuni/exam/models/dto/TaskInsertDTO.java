package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@XmlRootElement(name = "task")
@XmlAccessorType(value = XmlAccessType.NONE)
public class TaskInsertDTO {
    @XmlElement
    private BigDecimal price;
    @XmlElement
    private String date;
    @XmlElement
    private CarIdDTO car;
    @XmlElement
    private MechanicFirstNameDTO mechanic;
    @XmlElement
    private PartIdDTO part;

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public CarIdDTO getCar() {
        return car;
    }

    public void setCar(CarIdDTO car) {
        this.car = car;
    }

    public MechanicFirstNameDTO getMechanic() {
        return mechanic;
    }

    public void setMechanic(MechanicFirstNameDTO mechanic) {
        this.mechanic = mechanic;
    }

    public PartIdDTO getPart() {
        return part;
    }

    public void setPart(PartIdDTO part) {
        this.part = part;
    }

    public LocalDateTime getDateAsLocalDateTime(){
        return LocalDateTime.parse(this.getDate(), DATE_FORMATTER);
    }
}
