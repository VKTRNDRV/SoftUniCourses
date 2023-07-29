package softuni.exam.models.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@XmlRootElement(name = "astronomer")
@XmlAccessorType(value = XmlAccessType.NONE)
public class AstronomerImportDTO {

    @XmlElement(name = "average_observation_hours")
    @NotNull
    @Min(value = 500)
    private Double averageObservationHours;

    @XmlElement
    private String birthday;

    @XmlElement(name = "first_name")
    // COMPOSITE UNIQUE
    @NotNull
    @Size(min = 2, max = 30)
    private String firstName;

    @XmlElement(name = "last_name")
    // COMPOSITE UNIQUE
    @NotNull
    @Size(min = 2, max = 30)
    private String lastName;

    @XmlElement
    @NotNull
    @Min(15000)
    private Double salary;

    @XmlElement(name = "observing_star_id")
    @Positive
    private Long ObservingStarId;



    public Double getAverageObservationHours() {
        return averageObservationHours;
    }

    public void setAverageObservationHours(Double averageObservationHours) {
        this.averageObservationHours = averageObservationHours;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Long getObservingStarId() {
        return ObservingStarId;
    }

    public void setObservingStarId(Long observingStarId) {
        ObservingStarId = observingStarId;
    }

    public boolean isBirthdayNull(){
        return birthday == null;
    }

    public LocalDate getBirthdayAsLocalDate(){
        return LocalDate.parse(birthday,
                DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
