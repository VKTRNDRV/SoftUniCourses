package softuni.exam.models.dtos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "ticket")
@XmlAccessorType(value = XmlAccessType.NONE)
public class TicketImportDTO {

    @XmlElement(name = "serial-number")
    @Size(min = 2)
    @NotNull
    private String SerialNumber;

    @XmlElement
    @Positive
    private BigDecimal price;

    @XmlElement(name = "take-off")
    private String takeOff;

    @XmlElement(name = "from-town")
    private TownNameDTO fromTown;

    @XmlElement(name = "to-town")
    private TownNameDTO toTown;

    @XmlElement
    private PassengerEmailDTO passenger;

    @XmlElement
    private PlaneRegisteredNumberDTO plane;


    public String getSerialNumber() {
        return SerialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        SerialNumber = serialNumber;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getTakeOff() {
        return takeOff;
    }

    public void setTakeOff(String takeOff) {
        this.takeOff = takeOff;
    }

    public TownNameDTO getFromTown() {
        return fromTown;
    }

    public void setFromTown(TownNameDTO fromTown) {
        this.fromTown = fromTown;
    }

    public TownNameDTO getToTown() {
        return toTown;
    }

    public void setToTown(TownNameDTO toTown) {
        this.toTown = toTown;
    }

    public PassengerEmailDTO getPassenger() {
        return passenger;
    }

    public void setPassenger(PassengerEmailDTO passenger) {
        this.passenger = passenger;
    }

    public PlaneRegisteredNumberDTO getPlane() {
        return plane;
    }

    public void setPlane(PlaneRegisteredNumberDTO plane) {
        this.plane = plane;
    }
}
