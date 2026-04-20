package pe.edu.upc.apirev.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdImage;
    @Column(name= "URLImage", length = 200, nullable = false)
    private String URLImage;
    @Column(name= "EsPrincipal", length = 200, nullable = false)
    private String EsPrincipal;

    public Image(int idImage, String URLImage, String esPrincipal) {
        IdImage = idImage;
        this.URLImage = URLImage;
        EsPrincipal = esPrincipal;
    }

    public int getIdImage() {
        return IdImage;
    }

    public void setIdImage(int idImage) {
        IdImage = idImage;
    }

    public String getURLImage() {
        return URLImage;
    }

    public void setURLImage(String URLImage) {
        this.URLImage = URLImage;
    }

    public String getEsPrincipal() {
        return EsPrincipal;
    }

    public void setEsPrincipal(String esPrincipal) {
        EsPrincipal = esPrincipal;
    }
}