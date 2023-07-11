package com.example.productsshop.domain.DTOs.categoryDTOs;

import com.example.productsshop.domain.entities.Category;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.util.HashSet;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryInsertJsonDTO {
    @Expose
    private String name;

    private static final Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .setPrettyPrinting()
            .serializeNulls()
            .create();

    private static final ModelMapper modelMapper = new ModelMapper();

    private static final PropertyMap<CategoryInsertJsonDTO, Category> DTO_TO_ENTITY_MAP =
            new PropertyMap<CategoryInsertJsonDTO, Category>() {
                @Override
                protected void configure() {
                    map().setName(source.getName());
                    map().setProducts(new HashSet<>());
                }
            };

    private static void addAllMappings(){
        if(modelMapper.getTypeMap(CategoryInsertJsonDTO.class, Category.class) == null){
            modelMapper.addMappings(DTO_TO_ENTITY_MAP);
        }
    }

    public Category mapToEntity(){
        addAllMappings();
        Category category = modelMapper.map(this, Category.class);
        return category;
    }

    public static CategoryInsertJsonDTO getInstanceFromJson(String json){
        return gson.fromJson(json, CategoryInsertJsonDTO.class);
    }

    public static CategoryInsertJsonDTO[] getInstancesFromJson(String json){
        return gson.fromJson(json, CategoryInsertJsonDTO[].class);
    }
}
