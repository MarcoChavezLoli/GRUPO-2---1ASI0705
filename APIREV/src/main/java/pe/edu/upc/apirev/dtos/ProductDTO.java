package pe.edu.upc.apirev.dtos;

public class ProductDTO {
    private int IdProduct;
    private String NameProduct;
    private String DescriptionProduct;
    private String ConservationStatus;
    private int idBarter;
    private int IdCategory;

    public int getIdProduct() {
        return IdProduct;
    }

    public void setIdProduct(int idProduct) {
        IdProduct = idProduct;
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

    public int getIdBarter() {
        return idBarter;
    }

    public void setIdBarter(int idBarter) {
        this.idBarter = idBarter;
    }

    public int getIdCategory() {
        return IdCategory;
    }

    public void setIdCategory(int idCategory) {
        IdCategory = idCategory;
    }
}
