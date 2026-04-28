package pe.edu.upc.apirev.dtos;

import jakarta.persistence.Column;

import java.math.BigDecimal;

public class LocationGeneralDTO {
    private int idLocation;
    private String AddressLocation;
    private BigDecimal LatitudeLocation;
    private BigDecimal LongitudeLocation;
    private String DistrictLocation;

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
