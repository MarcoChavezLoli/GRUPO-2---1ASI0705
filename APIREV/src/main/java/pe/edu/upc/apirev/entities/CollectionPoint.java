package pe.edu.upc.apirev.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "CollectionPoint")
public class CollectionPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCollectionPoint;

    @Column(name = "CollectionPointName", length = 150, nullable = false)
    private String CollectionPointName;

    @Column(name = "CollectionPointAddress", length = 250, nullable = false)
    private String CollectionPointAddress;

    @Column(name = "CollectionPointLatitude", nullable = false)
    private double CollectionPointLatitude;

    @Column(name = "CollectionPointLongitude", nullable = false)
    private double CollectionPointLongitude;

    public CollectionPoint(int idCollectionPoint, String collectionPointName, String collectionPointAddress, double collectionPointLatitude, double collectionPointLongitude) {
        this.idCollectionPoint = idCollectionPoint;
        this.CollectionPointName = collectionPointName;
        this.CollectionPointAddress = collectionPointAddress;
        this.CollectionPointLatitude = collectionPointLatitude;
        this.CollectionPointLongitude = collectionPointLongitude;
    }

    public CollectionPoint() {
    }

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