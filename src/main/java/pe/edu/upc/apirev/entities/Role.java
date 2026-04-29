package pe.edu.upc.apirev.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRole;

    @Column(name = "NameRole", length = 50,nullable = false)
    private String NameRole;

    public Role() {

    }

    public Role(String nameRole, int idRole) {
        this.NameRole = nameRole;
        this.idRole = idRole;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getNameRole() {
        return NameRole;
    }

    public void setNameRole(String nameRole) {
        NameRole = nameRole;
    }
}
