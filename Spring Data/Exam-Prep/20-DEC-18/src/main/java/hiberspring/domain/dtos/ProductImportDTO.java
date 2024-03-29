package hiberspring.domain.dtos;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "product")
@XmlAccessorType(value = XmlAccessType.NONE)
public class ProductImportDTO {

    @XmlAttribute(name = "name")
    private String name;

    @XmlAttribute(name = "clients")
    private Integer clients;

    @XmlElement(name = "branch")
    private String branch;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getClients() {
        return clients;
    }

    public void setClients(Integer clients) {
        this.clients = clients;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public boolean containsInvalidNulls(){
        return name == null ||
                clients == null ||
                branch == null;
    }
}
