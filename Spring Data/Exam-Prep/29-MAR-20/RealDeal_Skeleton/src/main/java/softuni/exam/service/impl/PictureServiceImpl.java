package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.PictureImportDTO;
import softuni.exam.models.entities.Car;
import softuni.exam.models.entities.Picture;
import softuni.exam.repository.PictureRepository;
import softuni.exam.service.CarService;
import softuni.exam.service.PictureService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

@Service
public class PictureServiceImpl implements PictureService {

    private PictureRepository pictureRepository;

    private Gson gson;

    private static final String PICTURES_FILE_PATH = "src/main/resources/files/json/pictures.json";
    private ValidationUtil validationUtil;
    private ModelMapper modelMapper;

    private CarService carService;

    @Autowired
    public PictureServiceImpl(PictureRepository pictureRepository,
                              Gson gson,
                              ValidationUtil validationUtil,
                              ModelMapper modelMapper,
                              CarService carService) {
        this.pictureRepository = pictureRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.carService = carService;
    }

    @Override
    public boolean areImported() {
        return this.pictureRepository.count() > 0;
    }

    @Override
    public String readPicturesFromFile() throws IOException {
        return Files.readString(Path.of(PICTURES_FILE_PATH));
    }

    @Override
    public String importPictures() throws IOException {
        StringBuilder output = new StringBuilder();
        PictureImportDTO[] picDTOs = this.gson
                .fromJson(readPicturesFromFile(), PictureImportDTO[].class);
        for(PictureImportDTO picImportDTO : picDTOs){
            if(this.validationUtil.isValid(picImportDTO) &&
                    isUniqueName(picImportDTO)){
                Picture picture = this.modelMapper
                        .map(picImportDTO, Picture.class);
                picture.setDateAndTime(LocalDateTime.parse(
                        picImportDTO.getDateAndTime()
                        , DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                picture.setCar(this.carService
                        .getCarById(picImportDTO.getCar()));
                this.pictureRepository.save(picture);
                output.append("Successfully import picture ")
                        .append(picture.getName());
            }else {
                output.append("Invalid picture");
            }
            output.append(System.lineSeparator());
        }
        return output.toString().trim();
    }

    @Override
    public Set<Picture> getPicturesByCar(Car car) {
        return this.pictureRepository
                .findAllByCar(car);
    }

    @Override
    public Integer getCountOfPicturesByCar(Car car) {
        return this.pictureRepository.getCountOfPicsByCar(car);
    }

    private boolean isUniqueName(PictureImportDTO picImportDTO) {
        return this.pictureRepository
                .findFirstByName(picImportDTO.getName())
                .isEmpty();
    }
}
