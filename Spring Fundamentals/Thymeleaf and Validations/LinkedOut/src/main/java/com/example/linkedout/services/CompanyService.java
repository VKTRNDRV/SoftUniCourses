package com.example.linkedout.services;

import com.example.linkedout.domain.entities.Company;
import com.example.linkedout.domain.models.CompanyAddModel;
import com.example.linkedout.repositories.CompanyRepository;

import java.util.List;

public interface CompanyService {

    Boolean addCompany(CompanyAddModel companyAddModel);

    List<Company> getAllCompanies();

    List<String> getAllCompanyNames();

    Company getCompanyById(Long id);
}
