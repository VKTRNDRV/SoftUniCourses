package com.example.productsshop.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "categories")
@Getter
@Setter
public class Category extends BaseEntity{

    @Column(length = 15,
            nullable = false)
    private String name;

    @ManyToMany(targetEntity = Product.class,
            mappedBy = "categories")
    private Set<Product> products;

    public void addProduct(Product product){
        if(!this.products.contains(product)){
            this.products.add(product);
        }
    }
}
