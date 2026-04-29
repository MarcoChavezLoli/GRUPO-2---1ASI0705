package pe.edu.upc.apirev.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "CollectionPoint")
public class CollectionPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CollectionPointID;

    @Column(name = "CollectionPointName", length = 50,nullable = false)
    private String CollectionPointName;

    @OneToOne
    @JoinColumn(name = "idLocation")
    private Location location;

    public CollectionPoint() {
    }

    public CollectionPoint(int collectionPointID, String collectionPointName, Location location) {
        CollectionPointID = collectionPointID;
        CollectionPointName = collectionPointName;
        this.location = location;
    }

    public int getCollectionPointID() {
        return CollectionPointID;
    }

    public void setCollectionPointID(int collectionPointID) {
        CollectionPointID = collectionPointID;
    }

    public String getCollectionPointName() {
        return CollectionPointName;
    }

    public void setCollectionPointName(String collectionPointName) {
        CollectionPointName = collectionPointName;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
