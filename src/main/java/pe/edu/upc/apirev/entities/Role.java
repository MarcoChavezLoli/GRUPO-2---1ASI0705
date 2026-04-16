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

    @Column(name = "DescriptionRole", length = 150,nullable = false)
    private String DescriptionRole;

    public Role() {

    }

    public Role(int idRole, String nameRole, String descriptionRole) {
        this.idRole = idRole;
        NameRole = nameRole;
        DescriptionRole = descriptionRole;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getDescriptionRole() {
        return DescriptionRole;
    }

    public void setDescriptionRole(String descriptionRole) {
        DescriptionRole = descriptionRole;
    }

    public String getNameRole() {
        return NameRole;
    }

    public void setNameRole(String nameRole) {
        NameRole = nameRole;
    }
}
