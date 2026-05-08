package pe.edu.upc.apirev.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "PublicationSave")
public class PublicationSave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPublicationSave;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;

    @ManyToOne
    @JoinColumn(name = "idPublication")
    private Publication publication;


    public PublicationSave(int idPublicationSave, User user, Publication publication) {

        this.idPublicationSave = idPublicationSave;
        this.user = user;
        this.publication = publication;
    }

    public PublicationSave() {
    }

    public int getIdPublicationSave() {
        return idPublicationSave;
    }

    public void setIdPublicationSave(int idPublicationSave) {
        this.idPublicationSave = idPublicationSave;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }
}
