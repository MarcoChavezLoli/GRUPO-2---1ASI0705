package pe.edu.upc.apirev.dtos;

public class ItemDTO {

    private String ItemName;
    private String ItemDescription;
    private String ItemCondition;
    private int idCategory;

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public String getItemDescription() {
        return ItemDescription;
    }

    public void setItemDescription(String itemDescription) {
        ItemDescription = itemDescription;
    }

    public String getItemCondition() {
        return ItemCondition;
    }

    public void setItemCondition(String itemCondition) {
        ItemCondition = itemCondition;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }
}
