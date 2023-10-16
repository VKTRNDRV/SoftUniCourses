
package com.example.battleships.repository;

import com.example.battleships.domain.entity.Category;
import com.example.battleships.domain.enums.CategoryName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByName(CategoryName name);
}
