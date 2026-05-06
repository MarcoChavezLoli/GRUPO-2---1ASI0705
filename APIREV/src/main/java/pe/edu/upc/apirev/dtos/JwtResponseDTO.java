package pe.edu.upc.apirev.dtos;

import java.io.Serializable;

public class JwtResponseDTO implements Serializable {
    private final String jwttoken;
    public JwtResponseDTO(String jwttoken) {
        super();
        this.jwttoken = jwttoken;
    }
    public String getJwttoken() {
        return jwttoken;
    }
}
