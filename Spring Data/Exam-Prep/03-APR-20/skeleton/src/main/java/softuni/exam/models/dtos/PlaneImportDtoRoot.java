package softuni.exam.models.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "planes")
@XmlAccessorType(value = XmlAccessType.NONE)
public class PlaneImportDtoRoot {

    @XmlElement(name = "plane")
    private List<PlaneImportDTO> planes;



    public List<PlaneImportDTO> getPlanes() {
        return planes;
    }

    public void setPlanes(List<PlaneImportDTO> planes) {
        this.planes = planes;
    }
}
