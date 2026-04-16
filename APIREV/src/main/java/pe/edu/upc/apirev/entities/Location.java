package pe.edu.upc.apirev.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "Location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLocation;

    @Column (name = "AddressLocation",length = 200, nullable = false)
    private String AddressLocation;

    @Column (name = "LatitudeLocation",precision = 10, scale = 7, nullable = true)
    private BigDecimal LatitudeLocation;

    @Column (name = "LongitudeLocation",precision = 10, scale = 7, nullable = true)
    private BigDecimal LongitudeLocation;

    public Location() {

    }
    public Location(int idLocation, String addressLocation, BigDecimal LatitudeLocation, BigDecimal LongitudeLocation) {
        this.idLocation = idLocation;
        AddressLocation = addressLocation;
        this.LatitudeLocation = LatitudeLocation;
        this.LongitudeLocation = LongitudeLocation;


    }

    public int getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(int idLocation) {
        this.idLocation = idLocation;
    }

    public BigDecimal getLongitudeLocation() {
        return LongitudeLocation;
    }

    public void setLongitudeLocation(BigDecimal longitudeLocation) {
        LongitudeLocation = longitudeLocation;
    }

    public BigDecimal getLatitudeLocation() {
        return LatitudeLocation;
    }

    public void setLatitudeLocation(BigDecimal latitudeLocation) {
        LatitudeLocation = latitudeLocation;
    }

    public String getAddressLocation() {
        return AddressLocation;
    }

    public void setAddressLocation(String addressLocation) {
        AddressLocation = addressLocation;
    }
}
