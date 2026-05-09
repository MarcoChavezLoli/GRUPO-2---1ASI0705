package pe.edu.upc.apirev.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "PublicationSave")
public class PublicationSave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPublicationSave;
    @Column (name = "NamePublicationSave", nullable = false, length = 100)
    private String namePublcationSave;
    @Column(name = "DateSave", nullable = false)
    private LocalDate dateSave;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;

    @ManyToOne
    @JoinColumn(name = "idPublication")
    private Publication publication;

    public PublicationSave(int idPublicationSave, String namePublcationSave, LocalDate dateSave, User user, Publication publication) {
        this.idPublicationSave = idPublicationSave;
        this.namePublcationSave = namePublcationSave;
        this.dateSave = dateSave;
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

    public String getNamePublcationSave() {
        return namePublcationSave;
    }

    public void setNamePublcationSave(String namePublcationSave) {
        this.namePublcationSave = namePublcationSave;
    }

    public LocalDate getDateSave() {
        return dateSave;
    }

    public void setDateSave(LocalDate dateSave) {
        this.dateSave = dateSave;
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
