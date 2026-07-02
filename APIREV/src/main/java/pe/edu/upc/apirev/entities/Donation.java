package pe.edu.upc.apirev.entities;

import jakarta.persistence.*;

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
    private Item ItemId;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User idUser;

    public Donation() {
    }

    public Donation(int idDonation, String nameDonation, Item itemId, User idUser) {
        this.idDonation = idDonation;
        this.nameDonation = nameDonation;
        ItemId = itemId;
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



