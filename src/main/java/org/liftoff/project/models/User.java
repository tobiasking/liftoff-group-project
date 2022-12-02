package org.liftoff.project.models;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="registrationForm")
public class User extends AbstractEntity{

    @Column(name="user_name")
    private String userName;

    @Column(name="user_password")
    private String password;

    @Column(name="date_of_birth")
    private Date dateOfBirth;

    @Column(name="user_email")
    private String email;

    @Column(name="user_phone_number")
    private int phoneNumber;


    public User(String userName, String password, Date dateOfBirth, String email, int phoneNumber) {
        this.userName = userName;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public User() {
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return userName;
    }

}

