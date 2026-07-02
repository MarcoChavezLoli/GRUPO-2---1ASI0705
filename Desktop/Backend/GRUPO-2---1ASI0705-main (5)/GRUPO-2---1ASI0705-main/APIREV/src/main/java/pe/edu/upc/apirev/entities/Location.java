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
    @Column (name = "DistrictLocation", length = 100, nullable = false)
    private String DistrictLocation;

    public Location() {

    }

    public Location(int idLocation, String addressLocation, BigDecimal latitudeLocation, BigDecimal longitudeLocation, String districtLocation) {
        this.idLocation = idLocation;
        this.AddressLocation = addressLocation;
        this.LatitudeLocation = latitudeLocation;
        this.LongitudeLocation = longitudeLocation;
        this.DistrictLocation = districtLocation;
    }

    public int getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(int idLocation) {
        this.idLocation = idLocation;
    }

    public String getAddressLocation() {
        return AddressLocation;
    }

    public void setAddressLocation(String addressLocation) {
        AddressLocation = addressLocation;
    }

    public BigDecimal getLatitudeLocation() {
        return LatitudeLocation;
    }

    public void setLatitudeLocation(BigDecimal latitudeLocation) {
        LatitudeLocation = latitudeLocation;
    }

    public BigDecimal getLongitudeLocation() {
        return LongitudeLocation;
    }

    public void setLongitudeLocation(BigDecimal longitudeLocation) {
        LongitudeLocation = longitudeLocation;
    }

    public String getDistrictLocation() {
        return DistrictLocation;
    }

    public void setDistrictLocation(String districtLocation) {
        DistrictLocation = districtLocation;
    }
}
