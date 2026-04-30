package pe.edu.upc.apirev.dtos;

import java.time.LocalDate;

public class PublicationDTO {
    private String NamePublication;
    private String TypePublication;
    private LocalDate CreationDate;
    private boolean Status;
    private int idUser;
    private int idProduct;

    public String getNamePublication() {
        return NamePublication;
    }

    public void setNamePublication(String namePublication) {
        NamePublication = namePublication;
    }

    public String getTypePublication() {
        return TypePublication;
    }

    public void setTypePublication(String typePublication) {
        TypePublication = typePublication;
    }

    public LocalDate getCreationDate() {
        return CreationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        CreationDate = creationDate;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean status) {
        Status = status;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }
}
