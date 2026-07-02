package pe.edu.upc.apirev.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProduct;

    @Column(name = "NameProduct", nullable = false, length = 100)
    private String NameProduct;

    @Column(name = "DescriptionProduct", nullable = false, length = 250)
    private String DescriptionProduct;

    @Column(name = "ConservationStatus", nullable = false, length = 30)
    private String ConservationStatus;
    @ManyToOne
    @JoinColumn(name = "idBarter")
    private Barter barter;

    @ManyToOne
    @JoinColumn(name = "IdCategory")
    private Category category;

    public Product() {
    }

    public Product(int idProduct, String nameProduct, String descriptionProduct, String conservationStatus, Barter barter, Category category) {
        this.idProduct = idProduct;
        NameProduct = nameProduct;
        DescriptionProduct = descriptionProduct;
        ConservationStatus = conservationStatus;
        this.barter = barter;
        this.category = category;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return NameProduct;
    }

    public void setNameProduct(String nameProduct) {
        NameProduct = nameProduct;
    }

    public String getDescriptionProduct() {
        return DescriptionProduct;
    }

    public void setDescriptionProduct(String descriptionProduct) {
        DescriptionProduct = descriptionProduct;
    }

    public String getConservationStatus() {
        return ConservationStatus;
    }

    public void setConservationStatus(String conservationStatus) {
        ConservationStatus = conservationStatus;
    }

    public Barter getBarter() {
        return barter;
    }

    public void setBarter(Barter barter) {
        this.barter = barter;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
