package es.ua.dlsi.grfia.im3ws.muret.controller.payload;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class RegisterForm
{
    @NotBlank
    @Size(min=2, max = 60)
    private String username;

    @NotBlank
    @Size(min = 2, max = 40)
    private String password;

    @NotBlank
    @Email
    private String email;

    private String first_name;
    private String last_name;

    private Boolean administrator = false;

    private String adminCreator;

    public String getAdminCreator() {
        return adminCreator;
    }

    public void setAdminCreator(String adminCreator) {
        this.adminCreator = adminCreator;
    }

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

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Boolean administrator) {
        this.administrator = administrator;
    }
}
