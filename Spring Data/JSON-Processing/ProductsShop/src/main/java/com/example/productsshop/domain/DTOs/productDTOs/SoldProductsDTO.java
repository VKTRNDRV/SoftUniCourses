package com.example.productsshop.domain.DTOs.productDTOs;

import com.example.productsshop.domain.DTOs.userDTOs.UserWithSoldProductsDTO;
import com.example.productsshop.domain.entities.Product;
import com.example.productsshop.domain.entities.User;
import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class SoldProductsDTO {
    @Expose
    private int count;
    @Expose
    private List<ProductWithBuyerNamesDTO> products;

    private Set<Product> productEntities;


    private static final ModelMapper modelMapper = new ModelMapper();

    private static final PropertyMap<User, SoldProductsDTO> ENTITY_TO_DTO_MAP =
            new PropertyMap<User, SoldProductsDTO>() {
                @Override
                protected void configure() {
                    map().setCount(0);
                    map().setProducts(new ArrayList<>());
                    map().setProductEntities(source.getSellingProducts());
                }
            };

    private static void addAllMappings(){
        if(modelMapper.getTypeMap(User.class, SoldProductsDTO.class) == null){
            modelMapper.addMappings(ENTITY_TO_DTO_MAP);
        }
    }

    public static SoldProductsDTO mapToDTO(User userWithSoldProducts){
        addAllMappings();
        SoldProductsDTO dto = modelMapper.map(userWithSoldProducts, SoldProductsDTO.class);
        dto.fillFields();
        return dto;
    }

    public void fillFields(){
        for(Product product : productEntities){
            ProductWithBuyerNamesDTO productDTO = ProductWithBuyerNamesDTO.mapToDTO(product);
            this.products.add(productDTO);
        }
        this.setCount(this.getProducts().size());
    }
}
