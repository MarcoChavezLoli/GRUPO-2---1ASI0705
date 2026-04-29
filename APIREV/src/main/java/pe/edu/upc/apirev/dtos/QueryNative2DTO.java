package pe.edu.upc.apirev.dtos;

public class QueryNative2DTO {
    private  int idUser;
    private String nameUser;
    private int quantityRecycling;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public int getQuantityRecycling() {
        return quantityRecycling;
    }

    public void setQuantityRecycling(int quantityRecycling) {
        this.quantityRecycling = quantityRecycling;
    }
}
