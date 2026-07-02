package pe.edu.upc.apirev.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Publication")
public class Publication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPublication;
    @Column(name = "NamePublication", nullable = false, length = 100)
    private String NamePublication;

    @Column(name = "TypePublication", nullable = false, length = 50)
    private String TypePublication;

    @Column(name = "CreationDate", nullable = false)
    private LocalDate CreationDate;

    @Column(name = "Status", nullable = false)
    private boolean Status;
    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;
    @ManyToOne
    @JoinColumn(name = "idProduct")
    private Product product;

    public Publication(int idPublication, String namePublication, String typePublication, LocalDate creationDate, boolean status, User user, Product product) {
        this.idPublication = idPublication;
        this.NamePublication = namePublication;
        this.TypePublication = typePublication;
        this.CreationDate = creationDate;
        this.Status = status;
        this.user = user;
        this.product = product;
    }

    public Publication() {

    }

    public int getIdPublication() {
        return idPublication;
    }

    public void setIdPublication(int idPublication) {
        this.idPublication = idPublication;
    }

    public String getNamePublication() {
        return NamePublication;
    }

    public void setNamePublication(String namePublication) {
        NamePublication = namePublication;
    }

    public LocalDate getCreationDate() {
        return CreationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        CreationDate = creationDate;
    }

    public String getTypePublication() {
        return TypePublication;
    }

    public void setTypePublication(String typePublication) {
        TypePublication = typePublication;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean status) {
        Status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
