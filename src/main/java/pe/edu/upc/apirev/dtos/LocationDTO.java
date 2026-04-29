package pe.edu.upc.apirev.dtos;

import java.math.BigDecimal;

public class LocationDTO {
    private String AddressLocation;
    private BigDecimal LatitudeLocation;
    private BigDecimal LongitudeLocation;
    private String DistrictLocation;

    public String getAddressLocation() {
        return AddressLocation;
    }

    public void setAddressLocation(String addressLocation) {
        AddressLocation = addressLocation;
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

    public String getDistrictLocation() {
        return DistrictLocation;
    }

    public void setDistrictLocation(String districtLocation) {
        DistrictLocation = districtLocation;
    }
}
