package org.liftoff.project.models.dto;

public class RegistrationDTO extends LoginDTO{

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }

    private String verifyPassword;
}
