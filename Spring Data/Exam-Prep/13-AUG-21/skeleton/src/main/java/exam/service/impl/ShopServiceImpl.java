package exam.service.impl;

import exam.model.Shop;
import exam.model.Town;
import exam.model.dtos.ShopImportDTO;
import exam.model.dtos.ShopImportRootDTO;
import exam.repository.ShopRepository;
import exam.repository.TownRepository;
import exam.service.ShopService;
import exam.util.ValidationUtils;
import exam.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@Service
public class ShopServiceImpl implements ShopService {

    private ShopRepository shopRepository;

    private TownRepository townRepository;

    private static final String SHOPS_FILE_PATH = "src/main/resources/files/xml/shops.xml";

    private XmlParser xmlParser;

    private ValidationUtils validationUtils;

    private ModelMapper modelMapper;

    @Autowired
    public ShopServiceImpl(ShopRepository shopRepository, TownRepository townRepository, XmlParser xmlParser, ValidationUtils validationUtils, ModelMapper modelMapper) {
        this.shopRepository = shopRepository;
        this.townRepository = townRepository;
        this.xmlParser = xmlParser;
        this.validationUtils = validationUtils;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.shopRepository.count() > 0;
    }

    @Override
    public String readShopsFileContent() {
        try {
            return Files.readString(Path.of(SHOPS_FILE_PATH));
        }catch (IOException ignored){}
        return "";
    }

    @Override
    public String importShops() throws JAXBException, FileNotFoundException {
        ShopImportRootDTO root = this.xmlParser
                .fromString(readShopsFileContent(), ShopImportRootDTO.class);
        List<ShopImportDTO> shopDTOs = root.getShops();
        StringBuilder output = new StringBuilder();
        boolean isValid;
        for(ShopImportDTO shopImportDTO : shopDTOs){
            isValid = true;
            Shop shop = null;
            if(this.validationUtils.isValid(shopImportDTO)
                    && isNameUnique(shopImportDTO.getName())){
                shop = this.modelMapper.map(shopImportDTO, Shop.class);
            }else {
                isValid = false;
            }

            // get town
            if(isValid){
                Optional<Town> town = this.townRepository
                        .findFirstByName(shopImportDTO.getTown().getName());
                if(town.isPresent()){
                    shop.setTown(town.get());
                }else {
                    isValid = false;
                }
            }

            if(isValid){
                output.append(String.format(
                        "Successfully imported Shop %s - %.0f\n",
                        shop.getName(), shop.getIncome()));
                this.shopRepository.save(shop);
            }else {
                output.append("Invalid shop\n");
            }
        }
        return output.toString().trim();
    }

    private boolean isNameUnique(String name) {
        return this.shopRepository
                .findFirstByName(name).isEmpty();
    }
}
