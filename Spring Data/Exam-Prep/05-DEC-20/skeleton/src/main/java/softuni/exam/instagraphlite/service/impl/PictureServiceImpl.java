package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.Picture;
import softuni.exam.instagraphlite.models.dtos.importDTOs.PictureImportDTO;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.util.ValidationUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class PictureServiceImpl implements PictureService {

    private PictureRepository pictureRepository;

    private String PICTURES_FILE_PATH = "src/main/resources/files/pictures.json";
    private Gson gson;
    private ValidationUtils validationUtils;
    private ModelMapper modelMapper;

    @Autowired
    public PictureServiceImpl(PictureRepository pictureRepository, Gson gson, ValidationUtils validationUtils, ModelMapper modelMapper) {
        this.pictureRepository = pictureRepository;
        this.gson = gson;
        this.validationUtils = validationUtils;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.pictureRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        try {
            return Files.readString(Path.of(PICTURES_FILE_PATH));
        }catch (IOException ignored){}
        return null;
    }

    @Override
    public String importPictures() throws IOException {
        PictureImportDTO[] picDTOs = this.gson
                .fromJson(readFromFileContent(), PictureImportDTO[].class);
        StringBuilder output = new StringBuilder();
        for(PictureImportDTO pictureDTO : picDTOs){
            if(this.validationUtils.isValid(pictureDTO) &&
                    isPathUnique(pictureDTO.getPath())){
                Picture picture = this.modelMapper
                        .map(pictureDTO, Picture.class);
                output.append(String.format(
                        "Successfully imported Picture, with size %.2f\n",
                        picture.getSize()));
                this.pictureRepository.save(picture);
            }else {
                output.append("Invalid Picture\n");
            }
        }
        return output.toString().trim();
    }

    private boolean isPathUnique(String path) {
        return this.pictureRepository
                .findFirstByPath(path)
                .isEmpty();
    }

    @Override
    public String exportPictures() {
        double minSize = 30000;
        List<Picture> orderedPics = this.pictureRepository
                .findAllBySizeGreaterThanOrderBySize(minSize);
        StringBuilder output = new StringBuilder();
        orderedPics.forEach(p -> output
                .append(String.format("%.2f – %s\n",
                        p.getSize(), p.getPath())));
        return output.toString().trim();
    }
}
