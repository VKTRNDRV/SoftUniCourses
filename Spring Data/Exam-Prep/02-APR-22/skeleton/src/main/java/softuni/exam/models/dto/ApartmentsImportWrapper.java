package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "apartments")
@XmlAccessorType(value = XmlAccessType.NONE)
public class ApartmentsImportWrapper {

    @XmlElement(name = "apartment")
    private List<ApartmentImportDTO> apartmentImportDTOs;

    public List<ApartmentImportDTO> getApartmentImportDTOs() {
        return apartmentImportDTOs;
    }

    public void setApartmentImportDTOs(List<ApartmentImportDTO> apartmentImportDTOs) {
        this.apartmentImportDTOs = apartmentImportDTOs;
    }
}
