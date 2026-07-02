package pe.edu.upc.apirev.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.apirev.entities.User;

public class RecyclingDTO {
    private int recyclingId;
    private String recyclingName;
    private int idMaterial;
    private int idUser;

    public int getRecyclingId() {
        return recyclingId;
    }

    public void setRecyclingId(int recyclingId) {
        this.recyclingId = recyclingId;
    }

    public String getRecyclingName() {
        return recyclingName;
    }

    public void setRecyclingName(String recyclingName) {
        this.recyclingName = recyclingName;
    }

    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
