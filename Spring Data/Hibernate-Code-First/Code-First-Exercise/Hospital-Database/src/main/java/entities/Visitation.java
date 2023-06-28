package entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "visitations")
public class Visitation extends BaseEntity{

    @ManyToOne(targetEntity = Patient.class)
    @JoinColumn(name = "patient_id"
            , referencedColumnName = "id"
            , nullable = false)
    private Patient patient;

    @Column(name = "date")
    private Date date;

    @Column(name = "comments")
    private String comments;

    public Visitation() {

    }

    public Patient getPatient() {
        return patient;
    }

    public Visitation(Patient patient){
        setPatient(patient);
    }

    public void setPatient(Patient patient) {
        if(patient == null){
            throw new IllegalArgumentException("Patient cannot be null");
        }
        this.patient = patient;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
