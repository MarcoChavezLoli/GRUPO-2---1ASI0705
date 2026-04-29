package pe.edu.upc.apirev.dtos;

import java.time.LocalDate;

public class QueryNativeUser {

    private int idUser;
    private String UserName;
    private String UserEmail;
    private LocalDate UserRegistrationDate;

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

    public LocalDate getUserRegistrationDate() {
        return UserRegistrationDate;
    }

    public void setUserRegistrationDate(LocalDate userRegistrationDate) {
        UserRegistrationDate = userRegistrationDate;
    }

    public String getUserEmail() {
        return UserEmail;
    }

    public void setUserEmail(String userEmail) {
        UserEmail = userEmail;
    }
}
