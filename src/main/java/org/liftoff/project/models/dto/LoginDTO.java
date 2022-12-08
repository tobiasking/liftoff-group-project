package org.liftoff.project.models.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class LoginDTO {
    @NotNull
    @NotBlank(message = "Username is required!")
    @Size(min = 5, max = 30, message = "Invalid username. Must be between 5 and 30 characters.")
    private String username;

    @NotNull
    @NotBlank(message = "Password is required!")
    @Size(min = 5, max = 30, message = "Invalid password. Must be between 5 and 30 characters.")
    private String password;


//    @NotNull
//    @NotBlank
//    @Size( max = 4, message = "Invalid date of birth Must be 4 characters.")
//    private Date dateOfBirth;


//    @NotNull
//    @NotBlank
//    @Size(min = 5, max = 30, message = "Invalid email. Must be between 5 and 30 characters.")
//    private String email;


//    @NotNull
//    @NotBlank
//    @Size(min = 5, max = 30, message = "Invalid password. Must be between 5 and 30 characters.")
//    private Integer phoneNumber;

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {

        this.username = username;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

//   public Date getDateOfBirth() {
//
//        return dateOfBirth;
//    }
//
//    public void setDateOfBirth(Date dateOfBirth) {
//        this.dateOfBirth = dateOfBirth;
//    }
//    public String getEmail() {
//
//        return email;
//   }
//
//    public void setEmail(String email) {
//
//        this.email = email;
    }

//    public Integer getPhoneNumber() {
//
//        return phoneNumber;
//    }
//
//    public void setPhoneNumber(Integer phoneNumber) {
//
//        this.phoneNumber = phoneNumber;
//   }
//
//}
