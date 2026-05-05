package pe.edu.upc.apirev.dtos;

import java.math.BigDecimal;

public class LocationDTO {
    private String addressLocation;
    private BigDecimal latitudeLocation;
    private BigDecimal longitudeLocation;
    private String districtLocation;

    public String getAddressLocation() {
        return addressLocation;
    }

    public void setAddressLocation(String addressLocation) {
        this.addressLocation = addressLocation;
    }

    public BigDecimal getLatitudeLocation() {
        return latitudeLocation;
    }

    public void setLatitudeLocation(BigDecimal latitudeLocation) {
        this.latitudeLocation = latitudeLocation;
    }

    public BigDecimal getLongitudeLocation() {
        return longitudeLocation;
    }

    public void setLongitudeLocation(BigDecimal longitudeLocation) {
        this.longitudeLocation = longitudeLocation;
    }

    public String getDistrictLocation() {
        return districtLocation;
    }

    public void setDistrictLocation(String districtLocation) {
        this.districtLocation = districtLocation;
    }
}
