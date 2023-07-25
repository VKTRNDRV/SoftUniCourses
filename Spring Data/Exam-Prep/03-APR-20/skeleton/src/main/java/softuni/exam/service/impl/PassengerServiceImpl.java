package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.PassengerImportDTO;
import softuni.exam.models.entities.Passenger;
import softuni.exam.repository.PassengerRepository;
import softuni.exam.repository.TicketRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.PassengerService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PassengerServiceImpl implements PassengerService {

    private PassengerRepository passengerRepository;

    private Gson gson;

    private ValidationUtil validationUtil;

    private ModelMapper modelMapper;

    private TownRepository townRepository;

    private TicketRepository ticketRepository;

    private static final String PASSENGERS_FILE_PATH = "src/main/resources/files/json/passengers.json";

    @Autowired
    public PassengerServiceImpl(PassengerRepository passengerRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper, TownRepository townRepository, TicketRepository ticketRepository) {
        this.passengerRepository = passengerRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.townRepository = townRepository;
        this.ticketRepository = ticketRepository;
    }

    @Override
    public boolean areImported() {
        return this.passengerRepository.count() > 0;
    }

    @Override
    public String readPassengersFileContent() throws IOException {
        return Files.readString(Path.of(PASSENGERS_FILE_PATH));
    }

    @Override
    public String importPassengers() throws IOException {
        PassengerImportDTO[] passengerDTOs = this.gson
                .fromJson(readPassengersFileContent(), PassengerImportDTO[].class);
        StringBuilder output = new StringBuilder();
        for(PassengerImportDTO passengerImportDTO : passengerDTOs){
            if(this.validationUtil.isValid(passengerImportDTO) &&
                    isEmailUnique(passengerImportDTO.getEmail())){
                Passenger passenger = this.modelMapper
                        .map(passengerImportDTO, Passenger.class);
                passenger.setTown(this.townRepository
                        .findFirstByName(passengerImportDTO.getTown())
                        .get());
                output.append(String.format(
                        "Successfully imported Passenger %s - %s",
                        passenger.getLastName(), passenger.getEmail()));
                this.passengerRepository.save(passenger);
            }else {
                output.append("Invalid Passenger");
            }
            output.append(System.lineSeparator());
        }
        return output.toString().trim();
    }

    private boolean isEmailUnique(String email) {
        return this.passengerRepository
                .findFirstByEmail(email).isEmpty();
    }

    @Override
    public String getPassengersOrderByTicketsCountDescendingThenByEmail() {
        List<Passenger> passengers = this.passengerRepository.findAll();
        Map<Passenger, Integer> passengerTicketCount = new HashMap<>();
        for(Passenger passenger : passengers){
            passengerTicketCount.put(
                    passenger,
                    this.ticketRepository.getCountOfTicketsByPassenger(passenger));
        }

        passengers.sort((p1,p2) -> {int result = passengerTicketCount.get(p2)
                    .compareTo(passengerTicketCount.get(p1));
            if(result == 0){
                result = p1.getEmail().compareTo(p2.getEmail());
            }
            return result;
        });
        StringBuilder output = new StringBuilder();
        for(Passenger passenger : passengers){
            output.append(String.format(
                    "Passenger %s  %s\n" +
                    "\tEmail - %s\n" +
                    "\tPhone - %s\n" +
                    "\tNumber of tickets - %d\n",
                    passenger.getFirstName(), passenger.getLastName(),
                    passenger.getEmail(),
                    passenger.getPhoneNumber(),
                    passengerTicketCount.get(passenger)));
        }
        return output.toString().trim();
    }
}
