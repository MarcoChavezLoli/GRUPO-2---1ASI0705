package pe.edu.upc.apirev.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdCategory;

    @Column(name = "NameCategory", length = 100,nullable = false)
    private String NameCategory;

    @Column(name = "DescriptionCategory", length = 200,nullable = false)
    private String DescriptionCategory;

    @Column(name = "StateCategory", nullable = false)
    private Boolean StateCategory;

    public Category() {

    }

    public Category(int IdCategory, String nameCategory, String descriptionCategory, Boolean StateCategory) {
        this.IdCategory = IdCategory;
        NameCategory = nameCategory;
        DescriptionCategory = descriptionCategory;
        this.StateCategory = StateCategory;
    }

    public int getIdCategory() {
        return IdCategory;
    }

    public void setIdCategory(int idCategory) {
        IdCategory = idCategory;
    }

    public Boolean getStateCategory() {
        return StateCategory;
    }

    public void setStateCategory(Boolean stateCategory) {
        StateCategory = stateCategory;
    }

    public String getNameCategory() {
        return NameCategory;
    }

    public void setNameCategory(String nameCategory) {
        NameCategory = nameCategory;
    }

    public String getDescriptionCategory() {
        return DescriptionCategory;
    }

    public void setDescriptionCategory(String descriptionCategory) {
        DescriptionCategory = descriptionCategory;
    }
}
