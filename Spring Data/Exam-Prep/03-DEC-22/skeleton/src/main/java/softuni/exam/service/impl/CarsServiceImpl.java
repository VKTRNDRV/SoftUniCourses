package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.Constants;
import softuni.exam.models.dto.CarInsertDTO;
import softuni.exam.models.dto.CarInsertDTOWrapper;
import softuni.exam.models.entity.Car;
import softuni.exam.models.entity.CarType;
import softuni.exam.repository.CarsRepository;
import softuni.exam.service.CarsService;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// TODO: Implement all methods
@Service
public class CarsServiceImpl implements CarsService {

    private CarsRepository carsRepository;
    private ModelMapper modelMapper;

    private XmlParser xmlParser;
    private static String CARS_FILE_PATH = "src/main/resources/files/xml/cars.xml";

    @Autowired
    public CarsServiceImpl(CarsRepository carsRepository, ModelMapper modelMapper, XmlParser xmlParser) {
        this.modelMapper = modelMapper;
        this.carsRepository = carsRepository;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return this.carsRepository.count() > 0;
    }

    @Override
    public String readCarsFromFile() throws IOException {
        return Files.readString(Path.of(CARS_FILE_PATH));
    }

    @Override
    public String importCars() throws IOException, JAXBException {
        StringBuilder output = new StringBuilder();
        List<CarInsertDTO> carInsertDTOs = new ArrayList<>();
        try {
            String xml = Files.readString(Path.of(CARS_FILE_PATH));
            CarInsertDTOWrapper wrapper = this.xmlParser.fromString(xml, CarInsertDTOWrapper.class);
            carInsertDTOs = wrapper.getCars();
        } catch (JAXBException e) {
            output.append(Arrays.toString(e.getStackTrace()));
        }
        for(CarInsertDTO carInsertDTO : carInsertDTOs){
            if(isValid(carInsertDTO)){
                Car car = this.modelMapper.map(carInsertDTO, Car.class);
                this.carsRepository.save(car);
                output.append(String.format(
                        Constants.SUCCESSFULLY_IMPORTED_FORMAT + Constants.CAR_IMPORT_FORMAT,
                        "car", car.getCarMake(), car.getCarModel()));
            }else {
                output.append(String.format(Constants.INVALID_FORMAT, "car"));
            }
            output.append(System.lineSeparator());
        }
        return output.toString().trim();
    }

    private boolean isValid(CarInsertDTO carInsertDTO){
        String carType = carInsertDTO.getCarType();
        String carMake = carInsertDTO.getCarMake();
        String carModel = carInsertDTO.getCarModel();
        Integer year = carInsertDTO.getYear();
        String plateNumber = carInsertDTO.getPlateNumber();
        Integer kilometers = carInsertDTO.getKilometers();
        Double engine = carInsertDTO.getEngine();
        if(carType == null || carMake == null || carModel == null || year == null ||
                plateNumber == null || kilometers == null || engine == null){
            return false;
        }
        if(!CarType.contains(carType) || carMake.length() < 2 || carMake.length() > 30 ||
                carModel.length() < 2 || carModel.length() > 30 ||
                year <= 0 || kilometers <= 0 || engine < 1){
            return false;
        }
        if(plateNumber.length() < 2 || plateNumber.length() > 30 ||
                this.carsRepository.findFirstByPlateNumber(plateNumber).isPresent()){
            return false;
        }

        return true;
    }
}
