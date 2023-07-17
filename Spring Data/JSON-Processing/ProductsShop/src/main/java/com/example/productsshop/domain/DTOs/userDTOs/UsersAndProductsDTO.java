package com.example.productsshop.domain.DTOs.userDTOs;

import com.example.productsshop.domain.DTOs.categoryDTOs.CategoryProductCountsInfoDTO;
import com.example.productsshop.domain.entities.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.annotation.*;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.NONE)
public class UsersAndProductsDTO {

    @Expose
    @XmlAttribute(name = "count")
    private int usersCount;

    @Expose
    @XmlElement(name = "user")
    private List<UserInfoAndSoldProductsDTO> users;

    private static Marshaller marshaller;

    static {
        try {
            marshaller = JAXBContext.newInstance(UsersAndProductsDTO.class).createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private static final Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .serializeNulls()
            .setPrettyPrinting()
            .create();

    private static final ModelMapper modelMapper = new ModelMapper();

    private static final PropertyMap<User[], UsersAndProductsDTO> ENTITY_TO_DTO_MAP =
            new PropertyMap<User[], UsersAndProductsDTO>() {
                @Override
                protected void configure() {
                    map().setUsersCount(source.length);
                    map().setUsers(new ArrayList<>());
                }
            };

    private static void addAllMappings(){
        if(modelMapper.getTypeMap(User[].class, UsersAndProductsDTO.class) == null){
            modelMapper.addMappings(ENTITY_TO_DTO_MAP);
        }
    }

    public static UsersAndProductsDTO create(User[] usersWithSoldProducts){
        UsersAndProductsDTO dto = modelMapper.map(usersWithSoldProducts, UsersAndProductsDTO.class);
        List<UserInfoAndSoldProductsDTO> usersDTOs = new ArrayList<>();
        for(User user : usersWithSoldProducts){
            usersDTOs.add(UserInfoAndSoldProductsDTO.mapToDTO(user));
        }
        dto.setUsers(usersDTOs);
        dto.setUsersCount(usersDTOs.size());
        return dto;
    }

    public String toJson(){
        return gson.toJson(this);
    }

    public String toXML(){
        String output = "";
        try {
            StringWriter stringWriter = new StringWriter();
            marshaller.marshal(this, stringWriter);
            output = stringWriter.toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return output;
    }


}
