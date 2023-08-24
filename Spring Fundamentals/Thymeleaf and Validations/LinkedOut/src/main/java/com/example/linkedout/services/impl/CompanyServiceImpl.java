package com.example.linkedout.services.impl;

import com.example.linkedout.domain.entities.Company;
import com.example.linkedout.domain.models.CompanyAddModel;
import com.example.linkedout.repositories.CompanyRepository;
import com.example.linkedout.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }



    @Override
    public Boolean addCompany(CompanyAddModel companyAddModel){
        if(!isCompanyNameUnique(companyAddModel.getName())){
            return false;
        }

        this.companyRepository.save(companyAddModel.toCompany());
        return true;
    }


    private boolean isCompanyNameUnique(String name){
        return this.companyRepository
                .findFirstByName(name)
                .isEmpty();
    }

    @Override
    public List<Company> getAllCompanies(){
        return this.companyRepository.findAll();
    }

    @Override
    public List<String> getAllCompanyNames(){
        return this.getAllCompanies().stream()
                .map(Company::getName)
                .collect(Collectors.toList());
    }

    @Override
    public Company getCompanyById(Long id){
        return this.companyRepository.findById(id).orElse(new Company());
    }
}
