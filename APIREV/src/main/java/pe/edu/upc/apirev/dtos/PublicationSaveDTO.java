package pe.edu.upc.apirev.dtos;

import jakarta.persistence.Column;
import pe.edu.upc.apirev.entities.Publication;
import pe.edu.upc.apirev.entities.User;

import java.time.LocalDate;

public class PublicationSaveDTO {
    private int idPublicationSave;
    private String namePublcationSave;
    private LocalDate dateSave;
    private int idPublication;

    public int getIdPublicationSave() {
        return idPublicationSave;
    }

    public void setIdPublicationSave(int idPublicationSave) {
        this.idPublicationSave = idPublicationSave;
    }

    public String getNamePublcationSave() {
        return namePublcationSave;
    }

    public void setNamePublcationSave(String namePublcationSave) {
        this.namePublcationSave = namePublcationSave;
    }

    public LocalDate getDateSave() {
        return dateSave;
    }

    public void setDateSave(LocalDate dateSave) {
        this.dateSave = dateSave;
    }

    public int getIdPublication() {
        return idPublication;
    }

    public void setIdPublication(int idPublication) {
        this.idPublication = idPublication;
    }
}
