package com.example.productsshop.domain.DTOs.userDTOs;

import com.example.productsshop.domain.entities.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserInsertJsonDTO implements Serializable {
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private int age;

    private static final Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .setPrettyPrinting()
            .serializeNulls()
            .create();

    private static final ModelMapper modelMapper = new ModelMapper();

    private static final PropertyMap<UserInsertJsonDTO, User> DTO_TO_ENTITY_MAP =
            new PropertyMap<UserInsertJsonDTO, User>() {
        @Override
        protected void configure() {
            map().setFirstName(source.getFirstName());
            map().setLastName(source.getLastName());
            map().setAge(source.getAge());
        }
    };

    private static void addAllMappings(){
        if(modelMapper.getTypeMap(UserInsertJsonDTO.class, User.class) == null){
            modelMapper.addMappings(DTO_TO_ENTITY_MAP);
        }
    }

    public User mapToEntity(){
        addAllMappings();
        User user = modelMapper.map(this, User.class);
        return user;
    }

    public static UserInsertJsonDTO getInstanceFromJson(String json){
        return gson.fromJson(json, UserInsertJsonDTO.class);
    }

    public static UserInsertJsonDTO[] getInstancesFromJson(String json){
        return gson.fromJson(json, UserInsertJsonDTO[].class);
    }
}
