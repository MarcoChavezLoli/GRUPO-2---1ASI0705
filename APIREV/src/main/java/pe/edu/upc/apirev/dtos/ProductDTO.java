package pe.edu.upc.apirev.dtos;

public class ProductDTO {
    private int iddProduct;
    private String nameProduct;
    private String descriptionProduct;
    private String conservationStatus;
    private int idBarter;
    private int idCategory;

    public int getIddProduct() {
        return iddProduct;
    }

    public void setIddProduct(int iddProduct) {
        this.iddProduct = iddProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getDescriptionProduct() {
        return descriptionProduct;
    }

    public void setDescriptionProduct(String descriptionProduct) {
        this.descriptionProduct = descriptionProduct;
    }

    public String getConservationStatus() {
        return conservationStatus;
    }

    public void setConservationStatus(String conservationStatus) {
        this.conservationStatus = conservationStatus;
    }

    public int getIdBarter() {
        return idBarter;
    }

    public void setIdBarter(int idBarter) {
        this.idBarter = idBarter;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }
}
