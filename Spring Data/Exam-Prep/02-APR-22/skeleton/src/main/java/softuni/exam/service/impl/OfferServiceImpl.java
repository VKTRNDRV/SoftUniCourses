package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.OfferImportDTO;
import softuni.exam.models.dto.OfferImportWrapper;
import softuni.exam.models.entity.Agent;
import softuni.exam.models.entity.Apartment;
import softuni.exam.models.entity.Offer;
import softuni.exam.models.enums.ApartmentType;
import softuni.exam.repository.AgentRepository;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.repository.OfferRepository;
import softuni.exam.service.OfferService;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@Service
public class OfferServiceImpl implements OfferService {

    private OfferRepository offerRepository;

    private AgentRepository agentRepository;

    private ApartmentRepository apartmentRepository;

    private ModelMapper modelMapper;

    private XmlParser xmlParser;

    private static String OFFERS_IMPORT_FILE_PATH = "src/main/resources/files/xml/offers.xml";


    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository,
                            AgentRepository agentRepository,
                            ApartmentRepository apartmentRepository,
                            ModelMapper modelMapper,
                            XmlParser xmlParser) {
        this.offerRepository = offerRepository;
        this.agentRepository = agentRepository;
        this.apartmentRepository = apartmentRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return this.offerRepository.count() > 0;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return Files.readString(Path.of(OFFERS_IMPORT_FILE_PATH));
    }

    @Override
    public String importOffers() throws IOException, JAXBException {
        StringBuilder output = new StringBuilder();
        String xml = readOffersFileContent();
        OfferImportWrapper wrapper = this.xmlParser.fromString(xml, OfferImportWrapper.class);
        List<OfferImportDTO> offerDTOs = wrapper.getOfferImportDTOs();
        for(OfferImportDTO offerImportDTO : offerDTOs){
            if(isValid(offerImportDTO)){
                Offer offer = this.modelMapper.map(offerImportDTO, Offer.class);
                Optional<Agent> agent = this.agentRepository.
                        findFirstByFirstName(offerImportDTO.getAgent().getName());
                agent.ifPresent(offer::setAgent);
                Optional<Apartment> apartment = this.apartmentRepository
                        .findById(offerImportDTO.getApartment().getId());
                apartment.ifPresent(offer::setApartment);
                this.offerRepository.save(offer);
                output.append(String.format("Successfully imported offer %.2f"
                        , offer.getPrice()));
            }else{
                output.append("Invalid offer");
            }
            output.append(System.lineSeparator());
        }
        return output.toString().trim();
    }

    private boolean isValid(OfferImportDTO offerImportDTO) {
        BigDecimal price = offerImportDTO.getPrice();
        String agentName = offerImportDTO.getAgent().getName();
        if(price.compareTo(BigDecimal.ZERO) < 1 ||
                this.agentRepository.findFirstByFirstName(agentName).isEmpty()){
            return false;
        }
        return true;
    }

    @Override
    public String exportOffers() {
        List<Offer> offers = this.offerRepository
                .findAllByApartmentApartmentType(ApartmentType.three_rooms);
        offers.sort(((o1, o2) -> {
            int result = o2.getApartment().getArea().compareTo(o1.getApartment().getArea());
            if(result == 0){
                result = o1.getPrice().compareTo(o2.getPrice());
            }
            return result;
        }));

        StringBuilder output = new StringBuilder();
        offers.forEach(o -> {
            output.append(String.format(
                    "Agent %s %s with offer №%d:\n" +
                    "   -Apartment area: %.2f\n" +
                    "   --Town: %s\n" +
                    "   ---Price: %.2f$\n",
                    o.getAgent().getFirstName(),
                    o.getAgent().getLastName(),
                    o.getId(),
                    o.getApartment().getArea(),
                    o.getApartment().getTown().getTownName(),
                    o.getPrice()));
        });
        return output.toString().trim();
    }
}
