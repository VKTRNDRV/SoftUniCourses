package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "offers")
@XmlAccessorType(value = XmlAccessType.NONE)
public class OfferImportWrapper {

    @XmlElement(name = "offer")
    private List<OfferImportDTO> offerImportDTOs;


    public List<OfferImportDTO> getOfferImportDTOs() {
        return offerImportDTOs;
    }

    public void setOfferImportDTOs(List<OfferImportDTO> offerImportDTOs) {
        this.offerImportDTOs = offerImportDTOs;
    }
}
