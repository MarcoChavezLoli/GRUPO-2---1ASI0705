package pe.edu.upc.apirev.dtos;

import java.time.LocalDate;

public class BarterDTO {
    private int idBarter;
    private String descriptionBarter;
    private boolean statusBarter;
    private LocalDate dateBarter;
    private int idUser;

    public int getIdBarter() {
        return idBarter;
    }

    public void setIdBarter(int idBarter) {
        this.idBarter = idBarter;
    }

    public String getDescriptionBarter() {
        return descriptionBarter;
    }

    public void setDescriptionBarter(String descriptionBarter) {
        descriptionBarter = descriptionBarter;
    }

    public boolean isStatusBarter() {
        return statusBarter;
    }

    public void setStatusBarter(boolean statusBarter) {
        statusBarter = statusBarter;
    }

    public LocalDate getDateBarter() {
        return dateBarter;
    }

    public void setDateBarter(LocalDate dateBarter) {
        dateBarter = dateBarter;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
