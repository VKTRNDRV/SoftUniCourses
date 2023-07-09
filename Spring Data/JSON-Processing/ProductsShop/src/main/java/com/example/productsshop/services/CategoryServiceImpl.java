package com.example.productsshop.services;

import com.example.productsshop.domain.entities.Category;
import com.example.productsshop.domain.entities.Product;
import com.example.productsshop.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService{

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void insert(Category category){
        this.categoryRepository.save(category);
    }


}
