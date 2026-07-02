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
        this.descriptionBarter = descriptionBarter;
    }

    public boolean isStatusBarter() {
        return statusBarter;
    }

    public void setStatusBarter(boolean statusBarter) {
        this.statusBarter = statusBarter;
    }

    public LocalDate getDateBarter() {
        return dateBarter;
    }

    public void setDateBarter(LocalDate dateBarter) {
        this.dateBarter = dateBarter;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
