package softuni.exam.models.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "tickets")
@XmlAccessorType(value = XmlAccessType.NONE)
public class TicketImportDtoRoot {

    @XmlElement(name = "ticket")
    private List<TicketImportDTO> tickets;


    public List<TicketImportDTO> getTickets() {
        return tickets;
    }

    public void setTickets(List<TicketImportDTO> tickets) {
        this.tickets = tickets;
    }
}
