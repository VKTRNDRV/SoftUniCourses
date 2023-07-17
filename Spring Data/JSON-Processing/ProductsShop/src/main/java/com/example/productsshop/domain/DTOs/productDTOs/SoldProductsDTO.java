package com.example.productsshop.domain.DTOs.productDTOs;

import com.example.productsshop.domain.DTOs.userDTOs.UserInfoAndSoldProductsDTO;
import com.example.productsshop.domain.DTOs.userDTOs.UserWithSoldProductsDTO;
import com.example.productsshop.domain.entities.Product;
import com.example.productsshop.domain.entities.User;
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
import java.util.Set;

@Getter
@Setter
@XmlRootElement(name = "sold-products")
@XmlAccessorType(XmlAccessType.NONE)
public class SoldProductsDTO {

    @Expose
    @XmlAttribute(name = "count")
    private int count;

    @Expose
    @XmlElement(name = "product")
    private List<ProductWithBuyerNamesDTO> products;

    private Set<Product> productEntities;



    private static Marshaller marshaller;

    static {
        try {
            marshaller = JAXBContext.newInstance(UserInfoAndSoldProductsDTO.class).createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }


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
