package hiberspring.domain.dtos;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "products")
@XmlAccessorType(value = XmlAccessType.NONE)
public class ProductImportDtoWrapper {

    @XmlElement(name = "product")
    private List<ProductImportDTO> productImportDTOs;

    public List<ProductImportDTO> getProductImportDTOs() {
        return productImportDTOs;
    }

    public void setProductImportDTOs(List<ProductImportDTO> productImportDTOs) {
        this.productImportDTOs = productImportDTOs;
    }
}
