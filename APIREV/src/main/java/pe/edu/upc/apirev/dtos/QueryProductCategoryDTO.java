package pe.edu.upc.apirev.dtos;

public class QueryProductCategoryDTO {
    private int IdCategory;
    private String nameCategory;
    private long totalProductos;

    public QueryProductCategoryDTO() {}

    public int getIdCategory() {
        return IdCategory;
    }

    public void setIdCategory(int idCategory) {
        IdCategory = idCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public long getTotalProductos() {
        return totalProductos;
    }

    public void setTotalProductos(long totalProductos) {
        this.totalProductos = totalProductos;
    }
}
