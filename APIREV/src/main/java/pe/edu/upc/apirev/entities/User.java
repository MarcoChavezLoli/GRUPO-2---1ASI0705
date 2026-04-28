package pe.edu.upc.apirev.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table (name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;
    @Column(name = "UserName", length = 200,nullable = false)
    private String UserName;
    @Column(name = "UserLastName", length = 200,nullable = false)
    private String UserLastName;
    @Column(name = "UserIdentityDocument", length = 8,nullable = false,unique = true)
    private String UserIdentityDocument;
    @Column(name = "UserEmail", length = 100,nullable = false,unique = true)
    private String UserEmail;
    @Column(name = "UserPassword", length = 250,nullable = false)
    private String UserPassword;
    @Column(name = "UserRegistrationDate", nullable = false)
    private LocalDate UserRegistrationDate;
    @ManyToOne
    @JoinColumn(name = "idRole")
    private Role role;

    public User(int idUser, String userName, String userLastName, String userIdentityDocument, String userEmail, String userPassword, LocalDate userRegistrationDate, Role role) {
        this.idUser = idUser;
        this.UserName = userName;
        this.UserLastName = userLastName;
        this.UserIdentityDocument = userIdentityDocument;
        this.UserEmail = userEmail;
        this.UserPassword = userPassword;
        this.UserRegistrationDate = userRegistrationDate;
        this.role = role;
    }
    public  User() {

    }

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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
