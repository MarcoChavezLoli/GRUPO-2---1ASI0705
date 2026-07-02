package pe.edu.upc.apirev.dtos;

public class QueryNativeCollectionPointDTO {
    private String address;
    private int quantityPoints;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getQuantityPoints() {
        return quantityPoints;
    }

    public void setQuantityPoints(int quantityPoints) {
        this.quantityPoints = quantityPoints;
    }
}