package org.liftoff.project.models.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;


public class RegisterDTO extends LoginDTO {

    //variables

    private Date dateOfBirth;

    @NotNull
    private String phoneNumber;

    @NotNull
    private String email;

    @NotBlank
    private String verifyPassword;

    private String bio;

    public String getVerifyPassword() {
        return verifyPassword;
    }
    //method
    public void setVerifyPassword(String verifyPassword) {

        this.verifyPassword = verifyPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
