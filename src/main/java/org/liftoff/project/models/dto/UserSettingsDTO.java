package org.liftoff.project.models.dto;

public class UserSettingsDTO {
    private String bio;
    private String email;
    private String password;
    private String passwordConfirm;

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }
    @Override
    public String toString() {
        return "NewUserSettings [bio=" + bio + ", email=" + email + ", password=" + password
                + ", passwordConfirm=" + passwordConfirm + "]";
    }
}
