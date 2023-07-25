package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.SellerImportDTO;
import softuni.exam.models.dtos.SellerImportDtoRoot;
import softuni.exam.models.entities.Seller;
import softuni.exam.models.enums.Rating;
import softuni.exam.repository.SellerRepository;
import softuni.exam.service.SellerService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class SellerServiceImpl implements SellerService {

    private SellerRepository sellerRepository;

    private XmlParser xmlParser;

    private ValidationUtil validationUtil;

    private static final String SELLERS_FILE_PATH = "src/main/resources/files/xml/sellers.xml";
    private ModelMapper modelMapper;

    @Autowired
    public SellerServiceImpl(SellerRepository sellerRepository,
                             XmlParser xmlParser,
                             ValidationUtil validationUtil,
                             ModelMapper modelMapper) {
        this.sellerRepository = sellerRepository;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.sellerRepository.count() > 0;
    }

    @Override
    public String readSellersFromFile() throws IOException {
        return Files.readString(Path.of(SELLERS_FILE_PATH));
    }

    @Override
    public String importSellers() throws IOException, JAXBException {
        StringBuilder output = new StringBuilder();
        SellerImportDtoRoot root = this.xmlParser
                .parseXML(readSellersFromFile(), SellerImportDtoRoot.class);
        List<SellerImportDTO> sellerDTOs = root.getSellers();
        for(SellerImportDTO sellerImportDTO : sellerDTOs){
            if(this.validationUtil.isValid(sellerImportDTO) &&
                    isEmailUnique(sellerImportDTO.getEmail()) &&
                    Rating.isValid(sellerImportDTO.getRating())){
                Seller seller = this.modelMapper
                        .map(sellerImportDTO, Seller.class);
                output.append(String.format(
                        "Successfully import seller %s - %s",
                        seller.getLastName(),
                        seller.getEmail()));
                this.sellerRepository.save(seller);
            }else {
                output.append("Invalid seller");
            }
            output.append(System.lineSeparator());
        }
        return output.toString().trim();
    }

    @Override
    public Seller getSellerById(Long id) {
        return this.sellerRepository.findById(id).get();
    }

    private boolean isEmailUnique(String email) {
        return this.sellerRepository
                .findFirstByEmail(email)
                .isEmpty();
    }
}
