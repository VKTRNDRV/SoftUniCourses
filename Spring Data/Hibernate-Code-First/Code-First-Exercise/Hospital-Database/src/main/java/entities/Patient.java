package entities;

import javax.persistence.*;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "patients")
public class Patient extends BaseEntity{

    @Column(name = "first_name"
            , nullable = false)
    private String firstName;

    @Column(name = "last_name"
            , nullable = false)
    private String lastName;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "imageURL")
    private String imageURL;

    @Column(name = "has_medical_insurance")
    private boolean hasMedicalInsurance;

    @OneToMany(mappedBy = "patient"
            , targetEntity = Visitation.class)
    private Set<Visitation> visitations;

    @ManyToOne(targetEntity = Diagnosis.class)
    @JoinColumn(name = "diagnosis_id"
            , referencedColumnName = "id")
    private Diagnosis diagnosis;

    @ManyToMany(targetEntity = Medicament.class)
    @JoinTable(name = "patients_medicaments"
            , joinColumns =
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
            , inverseJoinColumns =
    @JoinColumn(name = "medicament_id", referencedColumnName = "id"))
    private Set<Medicament> medicaments;

    public Patient() {

    }

    private void setFirstName(String firstName) {
        if(firstName.trim().isEmpty()){
            throw new IllegalArgumentException("firstName cannot be empty");
        }
        this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        if(firstName.trim().isEmpty()){
            throw new IllegalArgumentException("lastName cannot be empty");
        }
        this.lastName = lastName;
    }

    public Patient(String firstName, String lastName){
        setFirstName(firstName);
        setLastName(lastName);
        this.medicaments = new HashSet<>();
        this.visitations = new HashSet<>();
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setHasMedicalInsurance(boolean hasMedicalInsurance) {
        this.hasMedicalInsurance = hasMedicalInsurance;
    }

    public void setDiagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getImageURL() {
        return imageURL;
    }

    public boolean isHasMedicalInsurance() {
        return hasMedicalInsurance;
    }

    public Set<Visitation> getVisitations() {
        return Collections.unmodifiableSet(visitations);
    }
    public void addVisitation(Visitation visitation){
        this.visitations.add(visitation);
    }

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }

    public Set<Medicament> getMedicaments() {
        return Collections.unmodifiableSet(medicaments);
    }

    public void addMedicament(Medicament medicament){
        this.medicaments.add(medicament);
    }
}
