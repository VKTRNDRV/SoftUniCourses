package com.example.productsshop.services;

import com.example.productsshop.domain.entities.Product;
import com.example.productsshop.domain.entities.User;

import java.util.List;
import java.util.Set;

public interface ProductService {
    void insert(Product product);

    Product getRandomProduct();

    Set<Product> getRandomProducts(int size);

    void save(Product product);

    List<Product> getInPriceRangeNoBuyerSortedPriceAsc(double min, double max);

    List<Product> getAllSoldProductsByUser(User user);
}
