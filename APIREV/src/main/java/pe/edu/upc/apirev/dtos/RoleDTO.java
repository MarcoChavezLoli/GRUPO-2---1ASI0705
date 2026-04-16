package pe.edu.upc.apirev.dtos;

public class RoleDTO {
    private String NameRole;
    private String DescriptionRole;

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
