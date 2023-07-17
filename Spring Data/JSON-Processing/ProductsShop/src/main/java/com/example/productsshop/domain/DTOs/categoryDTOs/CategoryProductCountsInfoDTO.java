package com.example.productsshop.domain.DTOs.categoryDTOs;

import com.example.productsshop.domain.DTOs.productDTOs.ProductInPriceRangeDTO;
import com.example.productsshop.domain.DTOs.productDTOs.ProductWithBuyerNamesDTO;
import com.example.productsshop.domain.entities.Category;
import com.example.productsshop.domain.entities.Product;
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

import java.util.List;
import java.util.Set;

@Getter
@Setter
@XmlRootElement(name = "category")
@XmlAccessorType(XmlAccessType.NONE)
public class CategoryProductCountsInfoDTO {
    @Expose
    @XmlAttribute(name = "name")
    private String category;

    @Expose
    @XmlElement(name = "products-count")
    private int productsCount;

    @Expose
    @XmlElement(name = "average-price")
    private String avgPrice;

    @Expose
    @XmlElement(name = "total-revenue")
    private String totalRevenue;

    private Set<Product> products;



    private static Marshaller marshaller;

    static {
        try {
            marshaller = JAXBContext.newInstance(CategoryProductCountsInfoDTO.class).createMarshaller();
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

    private static final PropertyMap<Category, CategoryProductCountsInfoDTO> ENTITY_TO_DTO_MAP =
            new PropertyMap<Category, CategoryProductCountsInfoDTO>() {
                @Override
                protected void configure() {
                    map().setCategory(source.getName());
                    map().setProductsCount(0);
                    map().setAvgPrice("0");
                    map().setTotalRevenue("0");
                    map().setProducts(source.getProducts());
                }
            };

    private static void addAllMappings(){
        if(modelMapper.getTypeMap(Category.class, CategoryProductCountsInfoDTO.class) == null){
            modelMapper.addMappings(ENTITY_TO_DTO_MAP);
        }
    }

    public static CategoryProductCountsInfoDTO mapToDTO(Category category){
        addAllMappings();
        CategoryProductCountsInfoDTO dto = modelMapper.map(category, CategoryProductCountsInfoDTO.class);
        dto.calculateStats();
        return dto;
    }

    private void calculateStats(){
        int count = this.getProducts().size();
        this.setProductsCount(count);
        if(count > 0){
            double avgPrice = 0;
            for(Product product : this.getProducts()){
                avgPrice += product.getPrice();
            }
            this.setAvgPrice(String.format("%.6f", avgPrice));
            this.setTotalRevenue(String.format("%.2f", avgPrice / count));
        }else {
            this.setAvgPrice("0");
            this.setTotalRevenue("0");
        }
    }

    public String toJson(){
        return gson.toJson(this);
    }

    public static String toJson(CategoryProductCountsInfoDTO[] dtos){
        return gson.toJson(dtos);
    }
}
