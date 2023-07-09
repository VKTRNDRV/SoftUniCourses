package com.example.productsshop.services;

import com.example.productsshop.domain.entities.Product;

import java.util.Set;

public interface ProductService {
    void insert(Product product);

    Product getRandomProduct();

    Set<Product> getRandomProducts(int size);

    void save(Product product);
}
