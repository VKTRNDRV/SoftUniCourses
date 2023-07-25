package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.CarImportDTO;
import softuni.exam.models.entities.Car;
import softuni.exam.repository.CarRepository;
import softuni.exam.repository.PictureRepository;
import softuni.exam.service.CarService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;

    private Gson gson;

    private ValidationUtil validationUtil;

    private ModelMapper modelMapper;

    private static final String CARS_FILE_PATH = "src/main/resources/files/json/cars.json";
    private PictureRepository pictureRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository,
                          Gson gson,
                          ValidationUtil validationUtil,
                          ModelMapper modelMapper,
                          PictureRepository pictureService) {
        this.carRepository = carRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.pictureRepository = pictureService;
    }

    @Override
    public boolean areImported() {
        return this.carRepository.count() > 0;
    }

    @Override
    public String readCarsFileContent() throws IOException {
        return Files.readString(Path.of(CARS_FILE_PATH));
    }

    @Override
    public String importCars() throws IOException {
        StringBuilder output = new StringBuilder();
        CarImportDTO[] carDTOs = this.gson
                .fromJson(readCarsFileContent(), CarImportDTO[].class);
        for(CarImportDTO carImportDTO : carDTOs){
            if(this.validationUtil.isValid(carImportDTO) &&
                    isCompositeUnique(carImportDTO)){
                Car car = this.modelMapper.map(carImportDTO, Car.class);
                car.setRegisteredOn(LocalDate.parse(carImportDTO.getRegisteredOn(),
                        DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                this.carRepository.save(car);
                output.append(String.format(
                        "Successfully imported car - %s - %s",
                        car.getMake(), car.getModel()));
            }else {
                output.append("Invalid car");
            }

            output.append(System.lineSeparator());
        }
        return output.toString().trim();
    }

    private boolean isCompositeUnique(CarImportDTO carImportDTO) {
        return this.carRepository.findFirstByMakeAndModel(
                        carImportDTO.getMake(),
                        carImportDTO.getModel())
                .isEmpty();
    }

    @Override
    public String getCarsOrderByPicturesCountThenByMake() {
        List<Car> cars = this.carRepository.findAll();
        Map<Car, Integer> carPicsCount = new LinkedHashMap<>();
        for(Car car : cars){
            carPicsCount.put(
                    car,
                    this.pictureRepository.getCountOfPicsByCar(car));
        }
        cars.sort((c1, c2) -> {
            int result = carPicsCount.get(c2)
                    .compareTo(carPicsCount.get(c1));
            if(result == 0){
                result = c1.getMake().compareTo(c2.getMake());
            }
            return result;
        });

        StringBuilder output = new StringBuilder();
        for(Car car : cars){
            output.append(String.format(
                    "Car make - %s, model - %s\n",
                            car.getMake(), car.getModel()))
                    .append(String.format(
                            "\tKilometers - %d\n",
                            car.getKilometers()))
                    .append(String.format(
                            "\tRegistered on - %s\n",
                            car.getRegisteredOn()))
                    .append(String.format(
                            "\tNumber of pictures - %d\n",
                            carPicsCount.get(car)));
        }
        return output.toString().trim();
    }

    @Override
    public Car getCarById(Long id) {
        return this.carRepository.findById(id).get();
    }
}
