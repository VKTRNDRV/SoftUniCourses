package com.example.bookshopsystem.services;

import com.example.bookshopsystem.models.entities.Category;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public interface CategoryService {
    boolean isDataSeeded();

    void seedCategories(List<Category> categories);

    Category getRandomCategory();

    Set<Category> getRandomCategories();
}
