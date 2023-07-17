package com.example.productsshop.domain.DTOs.productDTOs;

import com.example.productsshop.domain.entities.Product;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.io.StringWriter;

@Getter
@Setter
@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.NONE)
public class ProductInPriceRangeDTO implements Serializable {
    @Expose
    @XmlAttribute(name = "name")
    private String name;

    @Expose
    @XmlAttribute(name = "price")
    private double price;

    @Expose
    @XmlAttribute(name = "seller")
    private String seller;

    private String sellerFirstName;
    private String sellerLastName;

    private static final Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .setPrettyPrinting()
            .serializeNulls()
            .create();

    private static Marshaller marshaller;

    static {
        try {
            marshaller = JAXBContext.newInstance(ProductInPriceRangeDTO.class).createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private static final ModelMapper modelMapper = new ModelMapper();

    private static final PropertyMap<Product, ProductInPriceRangeDTO> ENTITY_TO_DTO_MAP =
            new PropertyMap<Product, ProductInPriceRangeDTO>() {
                @Override
                protected void configure() {
                    map().setName(source.getName());
                    map().setPrice(source.getPrice());
                    map().setSellerFirstName(source.getSeller().getFirstName());
                    map().setSellerLastName(source.getSeller().getLastName());
                    map().setSeller("");
                }
            };

    private static void addAllMappings(){
        if(modelMapper.getTypeMap(Product.class, ProductInPriceRangeDTO.class) == null){
            modelMapper.addMappings(ENTITY_TO_DTO_MAP);
        }
    }

    public static ProductInPriceRangeDTO mapToDTO(Product product){
        addAllMappings();
        ProductInPriceRangeDTO dto = modelMapper.map(product, ProductInPriceRangeDTO.class);
        dto.setSellerName();
        return dto;
    }

    public static String toJSON(ProductInPriceRangeDTO[] dtos){
        return gson.toJson(dtos);
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

    public String toJSON(){
        return gson.toJson(this);
    }

    private void setSellerName(){
        if (this.sellerFirstName == null){
            seller = sellerLastName;
        }else {
            seller = String.join(" ",
                    sellerFirstName,
                    sellerLastName);
        }
    }
}
