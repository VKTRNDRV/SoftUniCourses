package com.example.mobilelele.services;

import com.example.mobilelele.repositories.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModelService {

    private ModelRepository modelRepository;

    @Autowired
    public ModelService(ModelRepository modelRepository){
        this.modelRepository = modelRepository;
    }
}
