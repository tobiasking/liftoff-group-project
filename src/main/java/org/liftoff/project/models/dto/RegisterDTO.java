package org.liftoff.project.models.dto;

public class RegisterDTO extends LoginDTO{

    //variable
    private String verifyPassword;
    public String getVerifyPassword() {

        return verifyPassword;
    }
    //method
    public void setVerifyPassword(String verifyPassword) {

        this.verifyPassword = verifyPassword;
    }

}
