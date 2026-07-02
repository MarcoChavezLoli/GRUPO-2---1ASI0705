package pe.edu.upc.apirev.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Donation")
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDonation;

    @Column(name = "NameDonation", length = 25, nullable = false)
    private String nameDonation;

    @ManyToOne
    @JoinColumn(name = "ItemId")
    private Item itemId;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User idUser;

    public Donation() {
    }

    public Donation(int idDonation, String nameDonation, Item itemId, User idUser) {
        this.idDonation = idDonation;
        this.nameDonation = nameDonation;
        this.itemId = itemId;
        this.idUser = idUser;
    }

    public int getIdDonation() {
        return idDonation;
    }

    public void setIdDonation(int idDonation) {
        this.idDonation = idDonation;
    }

    public String getNameDonation() {
        return nameDonation;
    }

    public void setNameDonation(String nameDonation) {
        this.nameDonation = nameDonation;
    }

    public Item getItemId() {
        return itemId;
    }

    public void setItemId(Item itemId) {
        this.itemId = itemId;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }
}



