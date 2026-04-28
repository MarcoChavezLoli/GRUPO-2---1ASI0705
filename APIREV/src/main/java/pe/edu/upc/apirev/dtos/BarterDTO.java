package pe.edu.upc.apirev.dtos;

import java.time.LocalDate;

public class BarterDTO {
    private int idBarter;
    private String DescriptionBarter;
    private boolean StatusBarter;
    private LocalDate DateBarter;
    private int idUser;

    public int getIdBarter() {
        return idBarter;
    }

    public void setIdBarter(int idBarter) {
        this.idBarter = idBarter;
    }

    public String getDescriptionBarter() {
        return DescriptionBarter;
    }

    public void setDescriptionBarter(String descriptionBarter) {
        DescriptionBarter = descriptionBarter;
    }

    public boolean isStatusBarter() {
        return StatusBarter;
    }

    public void setStatusBarter(boolean statusBarter) {
        StatusBarter = statusBarter;
    }

    public LocalDate getDateBarter() {
        return DateBarter;
    }

    public void setDateBarter(LocalDate dateBarter) {
        DateBarter = dateBarter;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
}
