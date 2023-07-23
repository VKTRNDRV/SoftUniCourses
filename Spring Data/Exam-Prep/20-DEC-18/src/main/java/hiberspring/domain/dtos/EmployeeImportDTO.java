package hiberspring.domain.dtos;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "employee")
@XmlAccessorType(value = XmlAccessType.NONE)
public class EmployeeImportDTO {

    @XmlAttribute(name = "first-name")
    private String firstName;

    @XmlAttribute(name = "last-name")
    private String lastName;

    @XmlAttribute(name = "position")
    private String position;

    @XmlElement(name = "card")
    private String card;

    @XmlElement(name = "branch")
    private String branch;


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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public boolean containsInvalidNulls(){
        return firstName == null ||
                lastName == null ||
                position == null ||
                card == null ||
                branch == null;
    }
}
