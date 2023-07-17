package com.example.productsshop.domain.DTOs.userDTOs;

import com.example.productsshop.domain.DTOs.XMLDTOs.SoldProductsXMLDTO;
import com.example.productsshop.domain.DTOs.productDTOs.ProductInPriceRangeDTO;
import com.example.productsshop.domain.DTOs.productDTOs.ProductWithBuyerNamesDTO;
import com.example.productsshop.domain.entities.Product;
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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.NONE)
public class UserWithSoldProductsDTO {
    @Expose
    @XmlAttribute(name = "first-name")
    private String firstName;

    @Expose
    @XmlAttribute(name = "last-name")
    private String lastName;

    @Expose
    private List<ProductWithBuyerNamesDTO> soldProducts;

    @XmlElement(name = "sold-products")
    private SoldProductsXMLDTO soldProductsXMLDTO;



    private static Marshaller marshaller;

    static {
        try {
            marshaller = JAXBContext.newInstance(UserWithSoldProductsDTO.class).createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private static final Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .setPrettyPrinting()
            .serializeNulls()
            .create();

    private static final ModelMapper modelMapper = new ModelMapper();

    private static final PropertyMap<User, UserWithSoldProductsDTO> ENTITY_TO_DTO_MAP =
            new PropertyMap<User, UserWithSoldProductsDTO>() {
                @Override
                protected void configure() {
                    map().setFirstName(source.getFirstName());
                    map().setLastName(source.getLastName());
                    map().setSoldProducts(new ArrayList<>());
                }
            };

    private static void addAllMappings(){
        if(modelMapper.getTypeMap(User.class, UserWithSoldProductsDTO.class) == null){
            modelMapper.addMappings(ENTITY_TO_DTO_MAP);
        }
    }

    public static UserWithSoldProductsDTO mapToDTO(User user){
        addAllMappings();
        return modelMapper.map(user, UserWithSoldProductsDTO.class);
    }

    public static UserWithSoldProductsDTO mapToDTO(User user, Collection<ProductWithBuyerNamesDTO> soldProducts){
        addAllMappings();
        UserWithSoldProductsDTO dto = modelMapper.map(user, UserWithSoldProductsDTO.class);
        for(ProductWithBuyerNamesDTO product : soldProducts){
            dto.getSoldProducts().add(product);
        }
        return dto;
    }

    public String toJSON(){
        return gson.toJson(this);
    }

    public static String toJSON(UserWithSoldProductsDTO[] dtos){
        return gson.toJson(dtos);
    }

    public void setSoldProducts(List<ProductWithBuyerNamesDTO> productWithBuyerNamesDTOs){
        this.soldProducts = productWithBuyerNamesDTOs;
        this.soldProductsXMLDTO = new SoldProductsXMLDTO(productWithBuyerNamesDTOs);
    }
}
