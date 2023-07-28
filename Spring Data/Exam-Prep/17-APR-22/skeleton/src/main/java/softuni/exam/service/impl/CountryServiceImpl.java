package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CountryImportDTO;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CountryService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class CountryServiceImpl implements CountryService {

    private CountryRepository countryRepository;

    private static String COUNTRIES_FILE_PATH = "src/main/resources/files/json/countries.json";

    private Gson gson;
    private ValidationUtil validationUtil;
    private ModelMapper modelMapper;

    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.countryRepository = countryRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.countryRepository.count() > 0;
    }

    @Override
    public String readCountriesFromFile() throws IOException {
        return Files.readString(Path.of(COUNTRIES_FILE_PATH));
    }

    @Override
    public String importCountries() throws IOException {
        CountryImportDTO[] countryDTOs = this.gson.fromJson(
                readCountriesFromFile(), CountryImportDTO[].class);
        StringBuilder output = new StringBuilder();
        for(CountryImportDTO countryImportDTO : countryDTOs){
            if(this.validationUtil.isValid(countryImportDTO) &&
                    isCountryNameUnique(countryImportDTO.getCountryName())){
                Country country = this.modelMapper
                        .map(countryImportDTO, Country.class);
                output.append(String.format(
                        "Successfully imported country %s - %s\n",
                        country.getCountryName(), country.getCurrency()));
                this.countryRepository.save(country);
            }else {
                output.append("Invalid country\n");
            }
        }
        return output.toString().trim();
    }

    private boolean isCountryNameUnique(String countryName) {
        return this.countryRepository
                .findFirstByCountryName(countryName).isEmpty();
    }
}
