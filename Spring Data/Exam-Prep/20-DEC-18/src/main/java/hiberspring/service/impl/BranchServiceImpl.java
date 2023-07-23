package hiberspring.service.impl;

import com.google.gson.Gson;
import hiberspring.common.Constants;
import hiberspring.domain.dtos.BranchImportDTO;
import hiberspring.domain.entities.Branch;
import hiberspring.domain.entities.Town;
import hiberspring.repository.BranchRepository;
import hiberspring.repository.TownRepository;
import hiberspring.service.BranchService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

@Service
public class BranchServiceImpl implements BranchService {

    private BranchRepository branchRepository;

    private Gson gson;
    private ModelMapper modelMapper;
    private TownRepository townRepository;

    @Autowired
    public BranchServiceImpl(BranchRepository branchRepository, Gson gson, ModelMapper modelMapper, TownRepository townRepository) {
        this.branchRepository = branchRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.townRepository = townRepository;
    }

    @Override
    public Boolean branchesAreImported() {
        return this.branchRepository.count() > 0;
    }

    @Override
    public String readBranchesJsonFile() throws IOException {
        return Files.readString(Path.of(Constants.PATH_TO_FILES + "branches.json"));
    }

    @Override
    public String importBranches(String branchesFileContent) {
        StringBuilder output = new StringBuilder();
        BranchImportDTO[] branchDTOs = this.gson
                .fromJson(branchesFileContent, BranchImportDTO[].class);
        boolean isValid;
        for(BranchImportDTO branchImportDTO : branchDTOs){
            isValid = false;
            Town branchTown = null;
            if(!branchImportDTO.containsInvalidNulls()){
                Optional<Town> town = this.townRepository
                        .findFirstByName(branchImportDTO.getTown());
                if(town.isPresent()){
                    isValid = true;
                    branchTown = town.get();
                }
            }

            if(isValid){
                Branch branch = this.modelMapper.map(branchImportDTO, Branch.class);
                branch.setTown(branchTown);
                this.branchRepository.save(branch);
                output.append(String.format(Constants.SUCCESSFUL_IMPORT_MESSAGE,
                        "Branch", branch.getName()));
            }else {
                output.append(Constants.INCORRECT_DATA_MESSAGE);
            }
            output.append(System.lineSeparator());
        }
        return output.toString().trim();
    }
}
