package com.example.productsshop.services;

import com.example.productsshop.domain.entities.Category;
import com.example.productsshop.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public Category getCategoryWithProducts(Category category){
        return this.categoryRepository.getCategoryWithProducts(category);
    }

    @Override
    public List<Category> getAllCategoriesWithProductsSorted(){
        List<Category> categories = this.categoryRepository.findAll();
        for (int i = 0; i < categories.size(); i++) {
            Category category = categories.get(i);
            categories.set(i, this.categoryRepository.getCategoryWithProducts(category));
        }
        categories.sort((c1, c2) -> Integer.compare(
                c2.getProducts().size(),
                c1.getProducts().size()));
        return categories;
    }
}
