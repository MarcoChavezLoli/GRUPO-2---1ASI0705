package pe.edu.upc.apirev.dtos;

public class JwtRequestDTO {
    private String userEmail;
    private String userPassword;

    public JwtRequestDTO() {

    }

    public JwtRequestDTO(String userPassword, String userEmail) {
        this.userPassword = userPassword;
        this.userEmail = userEmail;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
