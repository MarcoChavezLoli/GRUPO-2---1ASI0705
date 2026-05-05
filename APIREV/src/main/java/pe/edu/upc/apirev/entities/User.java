package pe.edu.upc.apirev.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity@Table (name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;

    @Column(name = "UserName", length = 200,nullable = false)
    private String  userName;
    @Column(name = "UserLastName", length = 200,nullable = false)
    private String userLastName;
    @Column(name = "UserIdentityDocument", length = 8,nullable = false,unique = true)
    private String userIdentityDocument;
    @Column(name = "UserEmail", length = 100,nullable = false,unique = true)
    private String userEmail;
    @Column(nullable = false)
    private String userPassword;
    @Column(name = "UserRegistrationDate", nullable = false)
    private LocalDate userRegistrationDate;
    @Column(nullable = false)
    private Boolean enabled;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<Role> roles;

    public User()
    {

    }

    public User(String userName, String userIdentityDocument, String userEmail, String userLastName, String userPassword, LocalDate userRegistrationDate, Boolean enabled, List<Role> roles) {
        this.userName = userName;
        this.userIdentityDocument = userIdentityDocument;
        this.userEmail = userEmail;
        this.userLastName = userLastName;
        this.userPassword = userPassword;
        this.userRegistrationDate = userRegistrationDate;
        this.enabled = enabled;
        this.roles = roles;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserIdentityDocument() {
        return userIdentityDocument;
    }

    public void setUserIdentityDocument(String userIdentityDocument) {
        this.userIdentityDocument = userIdentityDocument;
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

    public LocalDate getUserRegistrationDate() {
        return userRegistrationDate;
    }

    public void setUserRegistrationDate(LocalDate userRegistrationDate) {
        this.userRegistrationDate = userRegistrationDate;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
