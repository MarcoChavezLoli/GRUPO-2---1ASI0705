package pe.edu.upc.apirev.dtos;

import pe.edu.upc.apirev.entities.Item;
import pe.edu.upc.apirev.entities.User;

public class DonationDTO {
    private int DonationId;
    private String NameDonation;
    private int ItemId;
    private int idUser;

    public int getDonationId() {
        return DonationId;
    }

    public void setDonationId(int donationId) {
        DonationId = donationId;
    }

    public String getNameDonation() {
        return NameDonation;
    }

    public void setNameDonation(String nameDonation) {
        NameDonation = nameDonation;
    }

    public int getItemId() {
        return ItemId;
    }

    public void setItemId(int itemId) {
        ItemId = itemId;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
