package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "diagnoses")
public class Diagnosis extends BaseEntity{

    @Column(name = "name"
            , nullable = false)
    private String name;

    @Column(name = "comments")
    private String comments;

    public Diagnosis() {

    }

    public Diagnosis(String name){
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

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
