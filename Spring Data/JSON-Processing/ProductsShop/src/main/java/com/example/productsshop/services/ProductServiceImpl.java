package com.example.productsshop.services;

import com.example.productsshop.domain.entities.Product;
import com.example.productsshop.domain.entities.User;
import com.example.productsshop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public void insert(Product product){
        this.productRepository.save(product);
    }

    @Override
    public Product getRandomProduct(){
        Optional<Product> product = this
                .productRepository
                .getRandomProduct();
        return product.orElse(null);
    }

    @Override
    public Set<Product> getRandomProducts(int size){
        if(size > this.productRepository.count()){
            size = (int) this.productRepository.count();
        }

        Set<Product> products = new HashSet<>();
        while(size-- > 0) {
            Optional<Product> fromDB = this
                    .productRepository
                    .getRandomProduct();

            if (fromDB.isPresent()) {
                boolean isDuplicate = false;
                for(Product product : products){
                    if (Objects.equals(
                            product.getId(),
                            fromDB.get().getId())){
                        isDuplicate = true;
                        size++;
                        break;
                    }
                }

                if(!isDuplicate){
                    products.add(fromDB.get());
                }
            }
        }
        return products;
    }

    @Override
    public void save(Product product){
        this.productRepository.save(product);
    }

    @Override
    public List<Product> getInPriceRangeNoBuyerSortedPriceAsc(double min, double max) {
        return this.productRepository.findAllByPriceBetweenAndBuyerIsNullOrderByPrice(min, max);
    }

    @Override
    public List<Product> getAllSoldProductsByUser(User user){
        return this.productRepository.findAllBySellerAndBuyerIsNotNull(user);
    }

}
