package de.itemis.registerpage.model;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {

    @NotNull
    @Size(min=5, max=16, message="{username.size}")
    private String username;
    private String password;
    private String retypedPassword;

    public User(String username, String password, String retypedPassword) {
        this.username = username;
        this.password = password;
        this.retypedPassword = retypedPassword;
    }

    public User() {

    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", retypedPassword='" + retypedPassword + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public String getRetypedPassword() {
        return retypedPassword;
    }

    public void setRetypedPassword(String retypedPassword) {
        this.retypedPassword = retypedPassword;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {

        this.username = username;
    }
}
