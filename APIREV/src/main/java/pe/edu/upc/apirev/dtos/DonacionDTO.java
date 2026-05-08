package pe.edu.upc.apirev.dtos;
import pe.edu.upc.apirev.entities.Item;
import pe.edu.upc.apirev.entities.User;

public class DonacionDTO {

    private int iddonacion;
    private String namedonacion;
    private Item ItemId;
    private User idUser;

    public int getIddonacion() {
        return iddonacion;
    }

    public void setIddonacion(int iddonacion) {
        this.iddonacion = iddonacion;
    }

    public String getNamedonacion() {
        return namedonacion;
    }

    public void setNamedonacion(String namedonacion) {
        this.namedonacion = namedonacion;
    }

    public Item getItemId() {
        return ItemId;
    }

    public void setItemId(Item itemId) {
        ItemId = itemId;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }
}
