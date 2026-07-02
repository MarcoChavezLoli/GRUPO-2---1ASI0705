package pe.edu.upc.apirev.dtos;

public class QueryPublicationDTO {
        private int idUser;
        private String userName;
        private long totalPublicaciones;

    public QueryPublicationDTO() {}

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getTotalPublicaciones() {
        return totalPublicaciones;
    }

    public void setTotalPublicaciones(long totalPublicaciones) {
        this.totalPublicaciones = totalPublicaciones;
    }
}
