package org.liftoff.project.models.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class RegisterDTO extends LoginDTO {

    //variables


    @NotNull
    @NotBlank
    @Size( max = 4, message = "Invalid date of birth Must be 4 characters.")
    private Date dateOfBirth;

    @NotNull
    @NotBlank
    @Size(min = 10, max = 20, message = "Invalid . Must be between 10 and 20 characters.")
    private Integer phoneNumber;

    @NotNull
    @NotBlank
    @Email
    private Integer email;


    private String verifyPassword;

    public String getVerifyPassword() {
        return verifyPassword;
    }
    //method
    public void setVerifyPassword(String verifyPassword) {

        this.verifyPassword = verifyPassword;
    }

    public Integer getEmail() {
        return email;
    }

    public void setEmail(Integer email) {
        this.email = email;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

}
