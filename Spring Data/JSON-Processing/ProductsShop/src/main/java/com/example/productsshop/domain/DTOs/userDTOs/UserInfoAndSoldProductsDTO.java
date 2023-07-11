package com.example.productsshop.domain.DTOs.userDTOs;

import com.example.productsshop.domain.DTOs.productDTOs.SoldProductsDTO;
import com.example.productsshop.domain.entities.Product;
import com.example.productsshop.domain.entities.User;
import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.util.ArrayList;
import java.util.Set;

@Getter
@Setter
public class UserInfoAndSoldProductsDTO {
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private int age;
    @Expose
    private SoldProductsDTO soldProducts;

    private static final ModelMapper modelMapper = new ModelMapper();

    private static final PropertyMap<User, UserInfoAndSoldProductsDTO> ENTITY_TO_DTO_MAP =
            new PropertyMap<User, UserInfoAndSoldProductsDTO>() {
                @Override
                protected void configure() {
                    map().setFirstName(source.getFirstName());
                    map().setLastName(source.getLastName());
                    map().setAge(source.getAge());
                    map().setSoldProducts(null);
                }
            };

    private static void addAllMappings(){
        if(modelMapper.getTypeMap(User.class, UserInfoAndSoldProductsDTO.class) == null){
            modelMapper.addMappings(ENTITY_TO_DTO_MAP);
        }
    }

    public static UserInfoAndSoldProductsDTO mapToDTO(User userWithSoldProducts){
        addAllMappings();
        SoldProductsDTO soldProductsDTO = SoldProductsDTO.mapToDTO(userWithSoldProducts);
        UserInfoAndSoldProductsDTO dto = modelMapper.map(userWithSoldProducts, UserInfoAndSoldProductsDTO.class);
        dto.setSoldProducts(soldProductsDTO);
        return dto;
    }
}
