package hiberspring.domain.dtos;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "employees")
@XmlAccessorType(value = XmlAccessType.NONE)
public class EmployeeImportDtoWrapper {

    @XmlElement(name = "employee")
    private List<EmployeeImportDTO> employeeImportDTOs;

    public List<EmployeeImportDTO> getEmployeeImportDTOs() {
        return employeeImportDTOs;
    }

    public void setEmployeeImportDTOs(List<EmployeeImportDTO> employeeImportDTOs) {
        this.employeeImportDTOs = employeeImportDTOs;
    }
}
