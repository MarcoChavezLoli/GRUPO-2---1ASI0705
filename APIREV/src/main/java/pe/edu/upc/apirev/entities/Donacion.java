package pe.edu.upc.apirev.entities;

import jakarta.persistence.*;

@Entity
@Table(name="Donacion")
public class Donacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int iddonacion;
    @Column(name="",length = 25,nullable = false)
    private String namedonacion;

    @ManyToOne
    @JoinColumn(name="ItemId")
    private Item ItemId;

    @ManyToOne
    @JoinColumn(name="idUser")
    private User idUser;

    public Donacion() {
    }

    public Donacion(int iddonacion, String namedonacion, Item itemId, User idUser) {
        this.iddonacion = iddonacion;
        this.namedonacion = namedonacion;
        ItemId = itemId;
        this.idUser = idUser;
    }

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
