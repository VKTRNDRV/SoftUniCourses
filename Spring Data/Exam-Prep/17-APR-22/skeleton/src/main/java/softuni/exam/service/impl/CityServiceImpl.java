package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CityImportDTO;
import softuni.exam.models.entity.City;
import softuni.exam.repository.CityRepository;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CityService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class CityServiceImpl implements CityService {

    private CityRepository cityRepository;

    private CountryRepository countryRepository;

    private static String CITIES_FILE_PATH = "src/main/resources/files/json/cities.json";

    private Gson gson;

    private ModelMapper modelMapper;

    private ValidationUtil validationUtil;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository, CountryRepository countryRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.cityRepository = cityRepository;
        this.countryRepository = countryRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.cityRepository.count() > 0;
    }

    @Override
    public String readCitiesFileContent() throws IOException {
        return Files.readString(Path.of(CITIES_FILE_PATH));
    }

    @Override
    public String importCities() throws IOException {
        CityImportDTO[] cityDTOs = this.gson.fromJson(
                readCitiesFileContent(), CityImportDTO[].class);
        StringBuilder output = new StringBuilder();
        for(CityImportDTO cityImportDTO : cityDTOs){
            if(this.validationUtil.isValid(cityImportDTO) &&
                    isCityNameUnique(cityImportDTO.getCityName())){
                City city = this.modelMapper
                        .map(cityImportDTO, City.class);
                city.setCountry(this.countryRepository
                        .getById(cityImportDTO.getCountry()));
                output.append(String.format(
                        "Successfully imported city %s - %d\n",
                        cityImportDTO.getCityName(),
                        cityImportDTO.getPopulation()));
                this.cityRepository.save(city);
            }else {
                output.append("Invalid city\n");
            }
        }
        return output.toString().trim();
    }

    private boolean isCityNameUnique(String cityName) {
        return this.cityRepository
                .findFirstByCityName(cityName).isEmpty();
    }
}
