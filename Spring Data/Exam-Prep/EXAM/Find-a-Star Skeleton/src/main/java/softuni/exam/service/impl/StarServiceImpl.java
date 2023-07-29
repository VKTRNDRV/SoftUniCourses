package softuni.exam.service.impl;

// TODO: Implement all methods

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.StarImportDTO;
import softuni.exam.models.entity.Star;
import softuni.exam.models.enums.StarType;
import softuni.exam.repository.AstronomerRepository;
import softuni.exam.repository.ConstellationRepository;
import softuni.exam.repository.StarRepository;
import softuni.exam.service.StarService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StarServiceImpl implements StarService {

    private StarRepository starRepository;

    private ConstellationRepository constellationRepository;

    private AstronomerRepository astronomerRepository;

    private static String STARS_FILE_PATH = "src/main/resources/files/json/stars.json";

    private ModelMapper modelMapper;

    private Gson gson;

    private ValidationUtil validationUtil;

    @Autowired
    public StarServiceImpl(StarRepository starRepository, ConstellationRepository constellationRepository, AstronomerRepository astronomerRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil) {
        this.starRepository = starRepository;
        this.constellationRepository = constellationRepository;
        this.astronomerRepository = astronomerRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.starRepository.count() > 0;
    }

    @Override
    public String readStarsFileContent() throws IOException {
        return Files.readString(Path.of(STARS_FILE_PATH));
    }

    @Override
    public String importStars() throws IOException {
        StarImportDTO[] starDTOs = this.gson.fromJson(
                readStarsFileContent(), StarImportDTO[].class);
        StringBuilder output = new StringBuilder();
        for(StarImportDTO starImportDTO : starDTOs){
            if(this.validationUtil.isValid(starImportDTO) &&
                    isNameUnique(starImportDTO.getName())){
                Star star = this.modelMapper.map(
                        starImportDTO, Star.class);
                star.setConstellation(this.constellationRepository
                        .getById(starImportDTO.getConstellation()));
                output.append(String.format(
                        "Successfully imported star %s - %.2f light years\n",
                        star.getName(), star.getLightYears()));
                this.starRepository.save(star);
            }else {
                output.append("Invalid star\n");
            }
        }
        return output.toString().trim();
    }

    private boolean isNameUnique(String name) {
        return this.starRepository
                .findFirstByName(name)
                .isEmpty();
    }

    @Override
    public String exportStars() {
        List<Star> stars = this.starRepository
                .findAllByStarType(StarType.RED_GIANT);
        stars = stars.stream().filter(star ->
                        this.astronomerRepository
                                .findAllByObservingStar(star)
                                .isEmpty())
                .collect(Collectors.toList());
        stars.sort(Comparator.comparing(Star::getLightYears));
        StringBuilder output = new StringBuilder();
        for(Star star : stars){
            output.append(String.format("Star: %s\n" +
                    "   *Distance: %.2f light years\n" +
                    "   **Description: %s\n" +
                    "   ***Constellation: %s\n",
                    star.getName(), star.getLightYears(),
                    star.getDescription(),
                    star.getConstellation().getName()));
        }
        return output.toString().trim();
    }
}
