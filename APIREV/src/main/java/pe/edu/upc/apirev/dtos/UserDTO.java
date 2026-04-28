package pe.edu.upc.apirev.dtos;


import java.time.LocalDate;

public class UserDTO {
    private int idUser;
    private String UserName;
    private String UserLastName;
    private String UserIdentityDocument;
    private String UserEmail;
    private String UserPassword;
    private LocalDate UserRegistrationDate;
    private int idRole;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserLastName() {
        return UserLastName;
    }

    public void setUserLastName(String userLastName) {
        UserLastName = userLastName;
    }

    public String getUserIdentityDocument() {
        return UserIdentityDocument;
    }

    public void setUserIdentityDocument(String userIdentityDocument) {
        UserIdentityDocument = userIdentityDocument;
    }

    public String getUserEmail() {
        return UserEmail;
    }

    public void setUserEmail(String userEmail) {
        UserEmail = userEmail;
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public void setUserPassword(String userPassword) {
        UserPassword = userPassword;
    }

    public LocalDate getUserRegistrationDate() {
        return UserRegistrationDate;
    }

    public void setUserRegistrationDate(LocalDate userRegistrationDate) {
        UserRegistrationDate = userRegistrationDate;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }
}
