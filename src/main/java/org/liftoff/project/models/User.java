package org.liftoff.project.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name="registration_form")
public class User extends AbstractEntity{

    @Column(name="name")
    private String userName;

    @Column(name="user_password")
    private String pwHash;


    @Column(name="date_of_birth")
    private Date dateOfBirth;

    @Column(name="email")
    private String email;

    @Column(name="phone_number")
    private String phoneNumber;

    //initialized variable for verifying and creating hashPW
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User(String userName, String password, Date dateOfBirth, String email, String phoneNumber) {
        this.userName = userName;
        // method to encode the PW field
        this.pwHash = encoder.encode(password);
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public User() {
    }


    //constructor that stores new user object to the DB
    public User(Object registerDTOUsername, Object registerDTOPassword) {

    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return pwHash;
    }

    public void setPassword(String password) {
        this.pwHash = password;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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


    //Add a method to check password values
    public boolean matchedPassword(String password) {
        return encoder.matches(password, pwHash);
    }

    public List<User> getUser() {
        return getUser();
    }

    @Override
    public String toString() {
        return userName;
    }


    public boolean isMatchingPassword(String password) {
        return true;
    }
}

