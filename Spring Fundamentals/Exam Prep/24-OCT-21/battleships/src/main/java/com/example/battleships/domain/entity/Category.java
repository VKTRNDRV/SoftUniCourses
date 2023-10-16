package com.example.battleships.domain.entity;

import com.example.battleships.domain.enums.CategoryName;
import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false, unique = true)
    private CategoryName name;

    @Column(columnDefinition = "TEXT",
            nullable = true)
    private String description;


    public CategoryName getName() {
        return name;
    }

    public Category setName(CategoryName name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Category setDescription(String description) {
        this.description = description;
        return this;
    }
}
