package softuni.exam.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.repository.PartsRepository;
import softuni.exam.service.PartsService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

// TODO: Implement all methods
@Service
public class PartsServiceImpl implements PartsService {

    private PartsRepository partsRepository;

    private static String PARTS_FILE_PATH = "src/main/resources/files/json/parts.json";

    @Autowired
    public PartsServiceImpl(PartsRepository partsRepository) {
        this.partsRepository = partsRepository;
    }

    @Override
    public boolean areImported() {
        return this.partsRepository.count() > 0;
    }

    @Override
    public String readPartsFileContent() throws IOException {
        return Files.readString(Path.of(PARTS_FILE_PATH));
    }

    @Override
    public String importParts() throws IOException {
        return null;
    }
}
