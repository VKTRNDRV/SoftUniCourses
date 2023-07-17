package com.example.productsshop.domain.DTOs.XMLDTOs;

import com.example.productsshop.domain.DTOs.categoryDTOs.CategoryProductCountsInfoDTO;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.StringWriter;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.NONE)
public class CategoriesProductsCountWrapperDTO {

    @XmlElement(name = "category")
    List<CategoryProductCountsInfoDTO> categories;

    private static Marshaller marshaller;

    static {
        try {
            marshaller = JAXBContext.newInstance(CategoriesProductsCountWrapperDTO.class).createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public String toXML(){
        String output = "";
        try {
            StringWriter stringWriter = new StringWriter();
            marshaller.marshal(this, stringWriter);
            output = stringWriter.toString();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return output;
    }
}
