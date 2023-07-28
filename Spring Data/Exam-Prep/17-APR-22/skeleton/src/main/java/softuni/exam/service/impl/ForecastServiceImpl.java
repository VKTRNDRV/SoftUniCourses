package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ForecastImportDTO;
import softuni.exam.models.dto.ForecastImportRootDTO;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.Forecast;
import softuni.exam.models.enums.DayOfWeek;
import softuni.exam.repository.CityRepository;
import softuni.exam.repository.ForecastRepository;
import softuni.exam.service.ForecastService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ForecastServiceImpl implements ForecastService {

    private ForecastRepository forecastRepository;

    private CityRepository cityRepository;

    private static String FORECASTS_FILE_PATH = "src/main/resources/files/xml/forecasts.xml";

    private XmlParser xmlParser;

    private ValidationUtil validationUtil;

    private ModelMapper modelMapper;

    @Autowired
    public ForecastServiceImpl(ForecastRepository forecastRepository, CityRepository cityRepository, XmlParser xmlParser, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.forecastRepository = forecastRepository;
        this.cityRepository = cityRepository;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.forecastRepository.count() > 0;
    }

    @Override
    public String readForecastsFromFile() throws IOException {
        return Files.readString(Path.of(FORECASTS_FILE_PATH));
    }

    @Override
    public String importForecasts() throws IOException, JAXBException {
        ForecastImportRootDTO root = this.xmlParser.fromString(
                readForecastsFromFile(), ForecastImportRootDTO.class);
        List<ForecastImportDTO> forecastDTOs = root.getForecasts();
        StringBuilder output = new StringBuilder();
        for(ForecastImportDTO forecastImportDTO : forecastDTOs){
            if(this.validationUtil.isValid(forecastImportDTO) &&
                    isDayAndCityValid(this.cityRepository.getById(
                            forecastImportDTO.getCity()),
                            forecastImportDTO.getDayOfWeek())){
                Forecast forecast = this.modelMapper.
                        map(forecastImportDTO, Forecast.class);
                forecast.setSunrise(forecastImportDTO
                        .getSunriseAsLocalTime());
                forecast.setSunset(forecastImportDTO
                        .getSunsetAsLocalTime());
                forecast.setCity(this.cityRepository.getById(
                        forecastImportDTO.getCity()));
                output.append(String.format(
                        "Successfully import forecast %s - %.2f\n",
                        forecast.getDayOfWeek().toString(),
                        forecast.getMaxTemperature()));
                this.forecastRepository.save(forecast);
            }else {
                output.append("Invalid forecast\n");
            }
        }
        return output.toString().trim();
    }

    private boolean isDayAndCityValid(City city, DayOfWeek dayOfWeek) {
        return this.forecastRepository
                .findFirstByCityAndDayOfWeek(city, dayOfWeek).isEmpty();
    }

    @Override
    public String exportForecasts() {
        List<Forecast> forecasts = this.forecastRepository
                .findAllByDayOfWeekOrderByMaxTemperatureDescId(DayOfWeek.SUNDAY);
        forecasts = forecasts.stream().filter(
                 forecast -> forecast.getCity().getPopulation() < 150000)
                 .collect(Collectors.toList());
        StringBuilder output = new StringBuilder();
        for(Forecast forecast : forecasts){
            output.append(String.format("City: %s:\n" +
                     "-min temperature: %.2f\n" +
                     "--max temperature: %.2f\n" +
                     "---sunrise: %s\n" +
                     "----sunset: %s\n",
                     forecast.getCity().getCityName(),
                     forecast.getMinTemperature(),
                     forecast.getMaxTemperature(),
                     forecast.getSunrise().toString(),
                     forecast.getSunset().toString()));
        }
        return output.toString().trim();
    }
}
