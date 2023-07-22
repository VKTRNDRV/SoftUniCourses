package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@XmlRootElement(name = "offer")
@XmlAccessorType(value = XmlAccessType.NONE)
public class OfferImportDTO {

    @XmlElement(name = "price")
    private BigDecimal price;

    @XmlElement(name = "agent")
    private AgentNameDTO agent;

    @XmlElement(name = "apartment")
    private ApartmentIdDTO apartment;

    @XmlElement(name = "publishedOn")
    private String publishedOn;

    private static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public AgentNameDTO getAgent() {
        return agent;
    }

    public void setAgent(AgentNameDTO agent) {
        this.agent = agent;
    }

    public ApartmentIdDTO getApartment() {
        return apartment;
    }

    public void setApartment(ApartmentIdDTO apartment) {
        this.apartment = apartment;
    }

    public String getPublishedOn() {
        return publishedOn;
    }

    public void setPublishedOn(String publishedOn) {
        this.publishedOn = publishedOn;
    }

    public LocalDate getDateAsLocalDate(){
        return LocalDate.parse(this.publishedOn, DATE_FORMATTER);
    }
}
