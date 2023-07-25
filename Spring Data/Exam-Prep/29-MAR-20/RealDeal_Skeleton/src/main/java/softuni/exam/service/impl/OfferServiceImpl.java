package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.OfferImportDto;
import softuni.exam.models.dtos.OfferImportDtoRoot;
import softuni.exam.models.entities.Car;
import softuni.exam.models.entities.Offer;
import softuni.exam.models.entities.Picture;
import softuni.exam.models.entities.Seller;
import softuni.exam.repository.OfferRepository;
import softuni.exam.service.CarService;
import softuni.exam.service.OfferService;
import softuni.exam.service.PictureService;
import softuni.exam.service.SellerService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class OfferServiceImpl implements OfferService {

    private OfferRepository offerRepository;

    private XmlParser xmlParser;

    private ValidationUtil validationUtil;

    private ModelMapper modelMapper;

    private PictureService pictureService;

    private static final String OFFERS_FILE_PATH = "src/main/resources/files/xml/offers.xml";
    private CarService carService;
    private SellerService sellerService;

    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository,
                            XmlParser xmlParser,
                            ValidationUtil validationUtil,
                            ModelMapper modelMapper,
                            PictureService pictureService,
                            CarService carService,
                            SellerService sellerService) {
        this.offerRepository = offerRepository;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.pictureService = pictureService;
        this.carService = carService;
        this.sellerService = sellerService;
    }

    @Override
    public boolean areImported() {
        return this.offerRepository.count() > 0;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return Files.readString(Path.of(OFFERS_FILE_PATH));
    }

    @Override
    public String importOffers() throws IOException, JAXBException {
        StringBuilder output = new StringBuilder();
        OfferImportDtoRoot root = this.xmlParser
                .parseXML(readOffersFileContent(), OfferImportDtoRoot.class);
        List<OfferImportDto> offerDTOs = root.getOffers();
        for(OfferImportDto offerImportDTO : offerDTOs){
            if(this.validationUtil.isValid(offerImportDTO) &&
                    isCompositeUnique(
                            offerImportDTO.getDescription(),
                            offerImportDTO.getAddedOn())){
                Offer offer = this.modelMapper.map(offerImportDTO, Offer.class);
                Car car = this.carService
                        .getCarById(offerImportDTO.getCar().getId());
                Seller seller = this.sellerService
                        .getSellerById(offerImportDTO.getSeller().getId());
                Set<Picture> pictures = new HashSet<>();
                pictures = this.pictureService
                        .getPicturesByCar(car);
                offer.setAddedOn(LocalDateTime.parse(
                        offerImportDTO.getAddedOn(),
                        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                offer.setCar(car);
                offer.setSeller(seller);
                offer.setPictures(pictures);
                output.append(String.format("Successfully import offer %s - %s",
                        offer.getAddedOn(),
                        offer.getHasGoldStatus()));
                this.offerRepository.save(offer);

            }else {
                output.append("Invalid offer");
            }
            output.append(System.lineSeparator());
        }
        return output.toString().trim();
    }

    private boolean isCompositeUnique(String description, String addedOn) {
        LocalDateTime dateAddedOn = LocalDateTime.parse(
                addedOn,
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return this.offerRepository
                .findFirstByDescriptionAndAddedOn(description, dateAddedOn)
                .isEmpty();
    }
}
