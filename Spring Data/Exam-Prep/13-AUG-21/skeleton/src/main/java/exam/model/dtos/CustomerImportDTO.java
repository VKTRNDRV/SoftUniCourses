package exam.model.dtos;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CustomerImportDTO {

    @Expose
    @NotNull
    @Size(min = 2)
    private String firstName;

    @Expose
    @NotNull
    @Size(min = 2)
    private String lastName;

    @Expose
    // UNIQUE
    @NotNull
    @Email
    private String email;

    @Expose
    @NotNull
    private String registeredOn;

    @Expose
    @NotNull
    private TownNameImportDTO town;


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(String registeredOn) {
        this.registeredOn = registeredOn;
    }

    public TownNameImportDTO getTown() {
        return town;
    }

    public void setTown(TownNameImportDTO town) {
        this.town = town;
    }

    public LocalDate getRegisteredOnAsLocalDate(){
        return LocalDate.parse(
                this.registeredOn,
                DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
