package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "medicaments")
public class Medicament extends BaseEntity{

    @Column(name = "name"
            , nullable = false)
    private String name;

    public Medicament() {
    }

    public Medicament(String name){
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be blank");
        }
        this.name = name;
    }
}
