package exam.service.impl;

import com.google.gson.Gson;
import exam.model.Laptop;
import exam.model.Shop;
import exam.model.Town;
import exam.model.dtos.LaptopImportDTO;
import exam.model.enums.WarrantyType;
import exam.repository.LaptopRepository;
import exam.repository.ShopRepository;
import exam.repository.TownRepository;
import exam.service.LaptopService;
import exam.util.ValidationUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@Service
public class LaptopServiceImpl implements LaptopService {

    private LaptopRepository laptopRepository;

    private ShopRepository shopRepository;

    private static final String LAPTOPS_FILE_PATH = "src/main/resources/files/json/laptops.json";

    private Gson gson;

    private ModelMapper modelMapper;

    private ValidationUtils validationUtils;
    private TownRepository townRepository;

    @Autowired
    public LaptopServiceImpl(LaptopRepository laptopRepository, ShopRepository shopRepository, Gson gson, ModelMapper modelMapper, ValidationUtils validationUtils, TownRepository townRepository) {
        this.laptopRepository = laptopRepository;
        this.shopRepository = shopRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
        this.townRepository = townRepository;
    }

    @Override
    public boolean areImported() {
        return this.laptopRepository.count() > 0;
    }

    @Override
    public String readLaptopsFileContent() throws IOException {
        return Files.readString(Path.of(LAPTOPS_FILE_PATH));
    }

    @Override
    public String importLaptops() throws IOException {
        LaptopImportDTO[] laptopDTOs = this.gson.fromJson(
                readLaptopsFileContent(), LaptopImportDTO[].class);
        StringBuilder output = new StringBuilder();
        boolean isValid;
        for(LaptopImportDTO laptopImportDTO : laptopDTOs){
            isValid = true;
            Laptop laptop = null;
            if(this.validationUtils.isValid(laptopImportDTO) &&
                    isMacAddressUnique(laptopImportDTO.getMacAddress())){
                laptop = this.modelMapper
                        .map(laptopImportDTO, Laptop.class);
//                laptop.setWarrantyType(WarrantyType.valueOf(
//                        laptopImportDTO.getWarrantyType()));
            }else {
                isValid = false;
            }

            // set shop
            if(isValid){
                Optional<Shop> shop = this.shopRepository
                        .findFirstByName(laptopImportDTO.getShop().getName());
                if(shop.isPresent()){
                    laptop.setShop(shop.get());
                }else {
                    isValid = false;
                }
            }

            if(isValid){
                output.append(String.format(
                        "Successfully imported Laptop %s - %.2f - %d - %d\n",
                        laptop.getMacAddress(), laptop.getCpuSpeed(),
                        laptop.getRam(), laptop.getStorage()));
                this.laptopRepository.save(laptop);
            }else {
                output.append("Invalid Laptop\n");
            }
        }
        return output.toString().trim();
    }

    private boolean isMacAddressUnique(String macAddress) {
        return this.laptopRepository
                .findFirstByMacAddress(macAddress).isEmpty();
    }

    @Override
    public String exportBestLaptops() {
        List<Laptop> sortedLaptops = this.laptopRepository
                .findAllByIdGreaterThanOrderByCpuSpeedDescRamDescStorageDescMacAddress(0L);
        StringBuilder output = new StringBuilder();
        for(Laptop laptop : sortedLaptops){
            output.append(String.format(
                    "Laptop - %s\n" +
                    "*Cpu speed - %.2f\n" +
                    "**Ram - %d\n" +
                    "***Storage - %d\n" +
                    "****Price - %.2f\n" +
                    "#Shop name - %s\n" +
                    "##Town - %s\n\n",
                    laptop.getMacAddress(), laptop.getCpuSpeed(),
                    laptop.getRam(), laptop.getStorage(),
                    laptop.getPrice(), laptop.getShop().getName(),
                    laptop.getShop().getTown().getName()));
        }
        return output.toString().trim();
    }
}
