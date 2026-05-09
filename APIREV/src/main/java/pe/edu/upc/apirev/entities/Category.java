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
    private boolean StateCategory;

    public Category() {

    }

    public Category(int idCategory, String nameCategory, String descriptionCategory, boolean stateCategory) {
        IdCategory = idCategory;
        NameCategory = nameCategory;
        DescriptionCategory = descriptionCategory;
        StateCategory = stateCategory;
    }

    public int getIdCategory() {
        return IdCategory;
    }

    public void setIdCategory(int idCategory) {
        IdCategory = idCategory;
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

    public boolean isStateCategory() {
        return StateCategory;
    }

    public void setStateCategory(boolean stateCategory) {
        StateCategory = stateCategory;
    }
}
