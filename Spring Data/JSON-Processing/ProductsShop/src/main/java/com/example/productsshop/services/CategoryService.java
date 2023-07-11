package com.example.productsshop.services;

import com.example.productsshop.domain.entities.Category;

import java.util.List;

public interface CategoryService {
    void insert(Category category);

    Category getCategoryWithProducts(Category category);

    List<Category> getAllCategoriesWithProductsSorted();
}
