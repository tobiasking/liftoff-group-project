package org.liftoff.project.models.dto;

import javax.validation.constraints.NotBlank;

public class RegisterDTO extends LoginDTO {

    //variables

/*
    @NotNull
    private Date dateOfBirth;

    @NotNull
    private Integer phoneNumber;

    @NotNull
    private Integer email;
*/
    @NotBlank
    private String verifyPassword;

    public String getVerifyPassword() {
        return verifyPassword;
    }
    //method
    public void setVerifyPassword(String verifyPassword) {

        this.verifyPassword = verifyPassword;
    }
/*
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
    }*/

}
