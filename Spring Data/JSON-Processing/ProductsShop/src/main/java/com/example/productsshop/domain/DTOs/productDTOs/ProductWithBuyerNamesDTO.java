package com.example.productsshop.domain.DTOs.productDTOs;

import com.example.productsshop.domain.entities.Product;
import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

@Getter
@Setter
public class ProductWithBuyerNamesDTO {

    @Expose
    private String name;
    @Expose
    private double price;
    @Expose
    private String buyerFirstName;
    @Expose
    private String buyerLastName;

    private static final ModelMapper modelMapper = new ModelMapper();

    private static final PropertyMap<Product, ProductWithBuyerNamesDTO> ENTITY_TO_DTO_MAP =
            new PropertyMap<Product, ProductWithBuyerNamesDTO>() {
                @Override
                protected void configure() {
                    map().setName(source.getName());
                    map().setPrice(source.getPrice());
                    map().setBuyerFirstName(source.getBuyer().getFirstName());
                    map().setBuyerLastName(source.getBuyer().getLastName());
                }
            };

    private static void addAllMappings(){
        if(modelMapper.getTypeMap(Product.class, ProductWithBuyerNamesDTO.class) == null){
            modelMapper.addMappings(ENTITY_TO_DTO_MAP);
        }
    }

    public static ProductWithBuyerNamesDTO mapToDTO(Product product){
        addAllMappings();
        return modelMapper.map(product, ProductWithBuyerNamesDTO.class);
    }
}
