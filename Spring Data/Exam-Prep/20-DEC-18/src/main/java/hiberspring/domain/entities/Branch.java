package hiberspring.domain.entities;

import javax.persistence.*;

@Entity
@Table(name = "branches")
public class Branch extends BaseEntity{

    @Column(nullable = false)
    private String name;


    @ManyToOne
    @JoinColumn(name = "town_id",
            nullable = false)
    private Town town;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }
}
