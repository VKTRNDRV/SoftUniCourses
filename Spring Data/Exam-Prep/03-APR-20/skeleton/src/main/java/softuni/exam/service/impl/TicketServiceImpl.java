package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.TicketImportDTO;
import softuni.exam.models.dtos.TicketImportDtoRoot;
import softuni.exam.models.entities.Ticket;
import softuni.exam.repository.PassengerRepository;
import softuni.exam.repository.PlaneRepository;
import softuni.exam.repository.TicketRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TicketService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    private TicketRepository ticketRepository;

    private XmlParser xmlParser;

    private ValidationUtil validationUtil;

    private ModelMapper modelMapper;

    private TownRepository townRepository;

    private PassengerRepository passengerRepository;

    private PlaneRepository planeRepository;
    private static final String TICKETS_FILE_PATH = "src/main/resources/files/xml/tickets.xml";

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository, XmlParser xmlParser, ValidationUtil validationUtil, ModelMapper modelMapper, TownRepository townRepository, PassengerRepository passengerRepository, PlaneRepository planeRepository) {
        this.ticketRepository = ticketRepository;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.townRepository = townRepository;
        this.passengerRepository = passengerRepository;
        this.planeRepository = planeRepository;
    }

    @Override
    public boolean areImported() {
        return this.ticketRepository.count() > 0;
    }

    @Override
    public String readTicketsFileContent() throws IOException {
        return Files.readString(Path.of(TICKETS_FILE_PATH));
    }

    @Override
    public String importTickets() throws IOException, JAXBException {
        TicketImportDtoRoot root = this.xmlParser
                .fromString(readTicketsFileContent(), TicketImportDtoRoot.class);
        List<TicketImportDTO> ticketDTOs = root.getTickets();
        StringBuilder output = new StringBuilder();
        for(TicketImportDTO ticketImportDTO : ticketDTOs){
            if(this.validationUtil.isValid(ticketImportDTO) &&
                    isSerialNumberUnique(ticketImportDTO.getSerialNumber())){
                Ticket ticket = this.modelMapper
                        .map(ticketImportDTO, Ticket.class);
                ticket.setTakeOff(LocalDateTime.parse(ticketImportDTO.getTakeOff(),
                        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                ticket.setFromTown(this.townRepository
                        .findFirstByName(ticketImportDTO.getFromTown().getName())
                        .get());
                ticket.setToTown(this.townRepository
                        .findFirstByName(ticketImportDTO.getToTown().getName())
                        .get());
                ticket.setPassenger(this.passengerRepository
                        .findFirstByEmail(ticketImportDTO.getPassenger().getEmail())
                        .get());
                ticket.setPlane(this.planeRepository
                        .findFirstByRegisteredNumber(ticketImportDTO.getPlane()
                                .getRegisteredNumber())
                        .get());
                output.append(String.format(
                        "Successfully imported Ticket %s - %s",
                        ticket.getFromTown().getName(),
                        ticket.getToTown().getName()));
                this.ticketRepository.save(ticket);
            }else {
                output.append("Invalid Ticket");
            }
            output.append(System.lineSeparator());
        }
        return output.toString().trim();
    }

    private boolean isSerialNumberUnique(String serialNumber) {
        return this.ticketRepository
                .findFirstBySerialNumber(serialNumber)
                .isEmpty();
    }
}
