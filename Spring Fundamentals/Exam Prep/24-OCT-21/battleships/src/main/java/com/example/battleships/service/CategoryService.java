package com.example.battleships.service;

import com.example.battleships.domain.dto.CategoryModel;
import com.example.battleships.domain.entity.Category;
import com.example.battleships.domain.enums.CategoryName;
import com.example.battleships.repository.CategoryRepository;
import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;
    private ModelMapper modelMapper;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @PostConstruct
    private void init(){
        if(this.categoryRepository.count() > 0){
            return;
        }

        Arrays.stream(CategoryName.values()).forEach(c ->{
            this.categoryRepository.save(new Category().setName(c));
        });
    }

    public CategoryModel findByName(CategoryName name) {
        return this.modelMapper.map(
                this.categoryRepository.findByName(name).orElseThrow(),
                CategoryModel.class);
    }
}
