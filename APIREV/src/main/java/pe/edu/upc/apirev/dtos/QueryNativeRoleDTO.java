package pe.edu.upc.apirev.dtos;

public class QueryNativeRoleDTO {
    private String NameRole;
    private int quantityUser;

    public String getNameRole() {
        return NameRole;
    }

    public void setNameRole(String nameRole) {
        NameRole = nameRole;
    }

    public int getQuantityUser() {
        return quantityUser;
    }

    public void setQuantityUser(int quantityUser) {
        this.quantityUser = quantityUser;
    }
}
