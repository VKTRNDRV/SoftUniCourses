package com.example.productsshop.repositories;

import com.example.productsshop.domain.entities.Product;
import com.example.productsshop.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT * FROM `products_shop`.products order by rand() limit 1"
            , nativeQuery = true)
    Optional<Product> getRandomProduct();
}
