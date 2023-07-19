package softuni.exam.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.repository.MechanicsRepository;
import softuni.exam.service.MechanicsService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

// TODO: Implement all methods
@Service
public class MechanicsServiceImpl implements MechanicsService {

    private MechanicsRepository mechanicsRepository;

    private static String MECHANICS_FILE_PATH = "src/main/resources/files/json/mechanics.json";

    @Autowired
    public MechanicsServiceImpl(MechanicsRepository mechanicsRepository) {
        this.mechanicsRepository = mechanicsRepository;
    }


    @Override
    public boolean areImported() {
        return this.mechanicsRepository.count() > 0;
    }

    @Override
    public String readMechanicsFromFile() throws IOException {
        return Files.readString(Path.of(MECHANICS_FILE_PATH));
    }

    @Override
    public String importMechanics() throws IOException {
        return null;
    }
}
