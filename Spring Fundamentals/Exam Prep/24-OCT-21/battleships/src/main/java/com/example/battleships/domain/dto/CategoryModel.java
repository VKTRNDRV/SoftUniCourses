package com.example.battleships.domain.dto;

import com.example.battleships.domain.enums.CategoryName;

public class CategoryModel {

    private Long id;

    private CategoryName name;

    private String description;


    public Long getId() {
        return id;
    }

    public CategoryModel setId(Long id) {
        this.id = id;
        return this;
    }

    public CategoryName getName() {
        return name;
    }

    public CategoryModel setName(CategoryName name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CategoryModel setDescription(String description) {
        this.description = description;
        return this;
    }
}
