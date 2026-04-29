package pe.edu.upc.apirev.dtos;

public class CategoryDTO {

    private int IdCategory;
    private String NameCategory;
    private String DescriptionCategory;
    private boolean StatusCategory;

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

    public boolean isStatusCategory() {
        return StatusCategory;
    }

    public void setStatusCategory(boolean statusCategory) {
        StatusCategory = statusCategory;
    }
}