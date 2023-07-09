package com.example.productsshop.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "products")
public class Product extends BaseEntity{
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double price;

    @ManyToOne
    @JoinColumn(name = "seller_id",
            referencedColumnName = "id",
            nullable = false)
    private User seller;

    @ManyToOne
    @JoinColumn(name = "buyer_id",
            referencedColumnName = "id")
    private User buyer;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "products_categories")
    private Set<Category> categories;

    public void addCategory(Category category){
        if(!this.categories.contains(category)) {
            this.categories.add(category);
        }
    }
}
