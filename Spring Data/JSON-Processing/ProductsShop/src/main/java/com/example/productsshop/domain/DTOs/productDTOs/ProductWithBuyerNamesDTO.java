package com.example.productsshop.domain.DTOs.productDTOs;

import com.example.productsshop.domain.entities.Product;
import com.google.gson.annotations.Expose;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

@Getter
@Setter
@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.NONE)
public class ProductWithBuyerNamesDTO {

    @Expose
    @XmlElement
    private String name;

    @Expose
    @XmlElement
    private double price;

    @Expose
    @XmlElement(name = "buyer-first-name")
    private String buyerFirstName;

    @Expose
    @XmlElement(name = "buyer-last-name")
    private String buyerLastName;



    private static Marshaller marshaller;

    static {
        try {
            marshaller = JAXBContext.newInstance(ProductWithBuyerNamesDTO.class).createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

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
