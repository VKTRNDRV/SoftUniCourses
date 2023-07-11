package com.example.productsshop.domain.DTOs.productDTOs;

import com.example.productsshop.domain.entities.Product;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductInsertJsonDTO {
    @Expose
    private String name;
    @Expose
    private double price;

    private static final Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .setPrettyPrinting()
            .serializeNulls()
            .create();

    private static final ModelMapper modelMapper = new ModelMapper();

    private static final PropertyMap<ProductInsertJsonDTO, Product> DTO_TO_ENTITY_MAP =
            new PropertyMap<ProductInsertJsonDTO, Product>() {
                @Override
                protected void configure() {
                    map().setName(source.getName());
                    map().setPrice(source.getPrice());
                    map().setSeller(null);
                    map().setBuyer(null);
                }
            };

    private static void addAllMappings(){
        if(modelMapper.getTypeMap(ProductInsertJsonDTO.class, Product.class) == null){
            modelMapper.addMappings(DTO_TO_ENTITY_MAP);
        }
    }

    public Product mapToEntity(){
        addAllMappings();
        Product product = modelMapper.map(this, Product.class);
        return product;
    }

    public static ProductInsertJsonDTO getInstanceFromJson(String json){
        return gson.fromJson(json, ProductInsertJsonDTO.class);
    }

    public static ProductInsertJsonDTO[] getInstancesFromJson(String json){
        return gson.fromJson(json, ProductInsertJsonDTO[].class);
    }
}
