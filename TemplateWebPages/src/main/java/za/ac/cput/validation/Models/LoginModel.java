package za.ac.cput.validation.Models;

//make sure to use this import instead of javax
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class LoginModel {

    // the below 2 annotations are for validation, self explain
    @NotNull(message="Username is required")
    @Size(min=3, max=15, message="Username needs to be between 3-15 characters")
    private String username;
    @NotNull(message="Password is required")
    @Size(min=8,max=20, message="Password should be between 8-20 characters")
    private String password;

    public LoginModel() {
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginModel{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
