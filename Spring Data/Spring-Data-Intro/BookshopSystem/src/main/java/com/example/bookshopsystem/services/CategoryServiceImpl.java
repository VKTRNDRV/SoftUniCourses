package com.example.bookshopsystem.services;

import com.example.bookshopsystem.models.entities.Category;
import com.example.bookshopsystem.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public boolean isDataSeeded() {
        return this.categoryRepository.count() > 0;
    }

    @Override
    public void seedCategories(List<Category> categories) {
        this.categoryRepository.saveAllAndFlush(categories);
    }

    @Override
    public Category getRandomCategory() {
        final int count = (int) this.categoryRepository.count();

        if (count != 0) {
            int randomId = new Random().nextInt(1, count) + 1;
            return this.categoryRepository.findById(randomId).orElseThrow();
        }

        throw new RuntimeException();
    }

    @Override
    public Set<Category> getRandomCategories() {
        Set<Category> categories = new HashSet<>();

        for (int i = 0; i < 1; i++) {
            categories.add(getRandomCategory());
        }

        return categories;
    }
}
