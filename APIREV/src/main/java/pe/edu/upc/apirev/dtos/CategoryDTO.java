package pe.edu.upc.apirev.dtos;

public class CategoryDTO {

    private int idCategory;
    private String nameCategory;
    private String descriptionCategory;
    private boolean stateCategory;

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getDescriptionCategory() {
        return descriptionCategory;
    }

    public void setDescriptionCategory(String descriptionCategory) {
        this.descriptionCategory = descriptionCategory;
    }

    public boolean isStateCategory() {
        return stateCategory;
    }

    public void setStateCategory(boolean stateCategory) {
        this.stateCategory = stateCategory;
    }
}