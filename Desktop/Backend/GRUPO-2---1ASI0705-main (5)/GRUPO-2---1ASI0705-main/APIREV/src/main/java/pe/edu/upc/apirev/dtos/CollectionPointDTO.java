package pe.edu.upc.apirev.dtos;

public class CollectionPointDTO {
    private int idCollectionPoint;
    private String collectionPointName;
    private String collectionPointAddress;
    private double collectionPointLatitude;
    private double collectionPointLongitude;

    public int getIdCollectionPoint() {
        return idCollectionPoint;
    }

    public void setIdCollectionPoint(int idCollectionPoint) {
        this.idCollectionPoint = idCollectionPoint;
    }

    public String getCollectionPointName() {
        return collectionPointName;
    }

    public void setCollectionPointName(String collectionPointName) {
        this.collectionPointName = collectionPointName;
    }

    public String getCollectionPointAddress() {
        return collectionPointAddress;
    }

    public void setCollectionPointAddress(String collectionPointAddress) {
        this.collectionPointAddress = collectionPointAddress;
    }

    public double getCollectionPointLatitude() {
        return collectionPointLatitude;
    }

    public void setCollectionPointLatitude(double collectionPointLatitude) {
        this.collectionPointLatitude = collectionPointLatitude;
    }

    public double getCollectionPointLongitude() {
        return collectionPointLongitude;
    }

    public void setCollectionPointLongitude(double collectionPointLongitude) {
        this.collectionPointLongitude = collectionPointLongitude;
    }
}