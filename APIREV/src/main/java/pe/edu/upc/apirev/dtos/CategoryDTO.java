package pe.edu.upc.apirev.dtos;


public class CategoryDTO {

    private String NameCategory;
    private String DescriptionCategory;
    private boolean StatusCategory;

    public String getNameCategory() {
        return NameCategory;
    }

    public void setNameCategory(String nameCategory) {
        NameCategory = nameCategory;
    }

    public boolean isStatusCategory() {
        return StatusCategory;
    }

    public void setStatusCategory(boolean statusCategory) {
        StatusCategory = statusCategory;
    }

    public String getDescriptionCategory() {
        return DescriptionCategory;
    }

    public void setDescriptionCategory(String descriptionCategory) {
        DescriptionCategory = descriptionCategory;
    }
}
