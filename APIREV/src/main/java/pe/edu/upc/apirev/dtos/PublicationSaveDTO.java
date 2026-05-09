package pe.edu.upc.apirev.dtos;

import pe.edu.upc.apirev.entities.Publication;
import pe.edu.upc.apirev.entities.User;

public class PublicationSaveDTO {
    private int idPublicationSave;
    private User user;
    private Publication publication;

    public PublicationSaveDTO() {
    }

    public PublicationSaveDTO(int idPublicationSave, User user, Publication publication) {
        this.idPublicationSave = idPublicationSave;
        this.user = user;
        this.publication = publication;
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
