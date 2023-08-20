package com.example.mobilelele.services;

import com.example.mobilelele.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandService {

    private BrandRepository brandRepository;

    @Autowired
    public BrandService(BrandRepository brandRepository){

        this.brandRepository = brandRepository;
    }
}
