package pe.edu.upc.apirev.dtos;

public class QuantityDonationUserDTO {

    private String user;
    private int quantityDonation;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getQuantityDonation() {
        return quantityDonation;
    }

    public void setQuantityDonation(int quantityDonation) {
        this.quantityDonation = quantityDonation;
    }
}
