package pe.edu.upc.apirev.dtos;

public class CollectionPointDTO {
    private int idCollectionPoint;
    private String CollectionPointName;
    private String CollectionPointAddress;
    private double CollectionPointLatitude;
    private double CollectionPointLongitude;

    public int getIdCollectionPoint() {
        return idCollectionPoint;
    }

    public void setIdCollectionPoint(int idCollectionPoint) {
        this.idCollectionPoint = idCollectionPoint;
    }

    public String getCollectionPointName() {
        return CollectionPointName;
    }

    public void setCollectionPointName(String collectionPointName) {
        CollectionPointName = collectionPointName;
    }

    public String getCollectionPointAddress() {
        return CollectionPointAddress;
    }

    public void setCollectionPointAddress(String collectionPointAddress) {
        CollectionPointAddress = collectionPointAddress;
    }

    public double getCollectionPointLatitude() {
        return CollectionPointLatitude;
    }

    public void setCollectionPointLatitude(double collectionPointLatitude) {
        CollectionPointLatitude = collectionPointLatitude;
    }

    public double getCollectionPointLongitude() {
        return CollectionPointLongitude;
    }

    public void setCollectionPointLongitude(double collectionPointLongitude) {
        CollectionPointLongitude = collectionPointLongitude;
    }
}