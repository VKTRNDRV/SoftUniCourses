package softuni.exam.models.dto;

import softuni.exam.models.entity.Car;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
@XmlRootElement(name = "cars")
@XmlAccessorType(value = XmlAccessType.NONE)
public class CarInsertDTOWrapper {
    @XmlElement(name = "car")
    private List<CarInsertDTO> cars;

    public List<CarInsertDTO> getCars() {
        return cars;
    }

    public void setCars(List<CarInsertDTO> cars) {
        this.cars = cars;
    }
}
