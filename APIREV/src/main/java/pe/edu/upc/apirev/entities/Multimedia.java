package pe.edu.upc.apirev.entities;

import jakarta.persistence.*;
@Entity

@Table(name = "Multimedia")
public class Multimedia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMultimedia;
    @Column(name = "NameMultimedia", nullable = false, length = 100)
    private String nameMultimedia;
    @Column(name = "DescriptionMultimedia", nullable = false, length = 250)
    private String descriptionMultimedia;

    @ManyToOne
    @JoinColumn(name = "idPublication")
    private Publication publication;
    public Multimedia(){

    }

    public Multimedia(int idMultimedia, String nameMultimedia, String descriptionMultimedia, Publication publication) {
        this.idMultimedia = idMultimedia;
        this.nameMultimedia = nameMultimedia;
        this.descriptionMultimedia = descriptionMultimedia;
        this.publication = publication;
    }

    public int getIdMultimedia() {
        return idMultimedia;
    }

    public void setIdMultimedia(int idMultimedia) {
        this.idMultimedia = idMultimedia;
    }

    public String getNameMultimedia() {
        return nameMultimedia;
    }

    public void setNameMultimedia(String nameMultimedia) {
        this.nameMultimedia = nameMultimedia;
    }

    public String getDescriptionMultimedia() {
        return descriptionMultimedia;
    }

    public void setDescriptionMultimedia(String descriptionMultimedia) {
        this.descriptionMultimedia = descriptionMultimedia;
    }

    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }
}
