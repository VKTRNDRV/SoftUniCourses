package com.example.productsshop.repositories;

import com.example.productsshop.domain.entities.Category;
import com.example.productsshop.domain.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query(value = "SELECT c from Category c JOIN fetch c.products WHERE c = :category")
    Category getCategoryWithProducts(Category category);
}
