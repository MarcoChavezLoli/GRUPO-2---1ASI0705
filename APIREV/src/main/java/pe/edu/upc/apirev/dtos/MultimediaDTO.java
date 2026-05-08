package pe.edu.upc.apirev.dtos;

public class MultimediaDTO {
    private int idMultimedia;
    private String nameMultimedia;
    private String descriptionMultimedia;
    private int idPublication;


    public int getIdMultimedia() {
        return idMultimedia;
    }

    public void setIdMultimedia(int idMultimedia) {
        this.idMultimedia = idMultimedia;
    }

    public String getNameMultimedia() {
        return nameMultimedia;
    }

    public void setNameMultimedia(String nameMultimedia) {
        this.nameMultimedia = nameMultimedia;
    }

    public String getDescriptionMultimedia() {
        return descriptionMultimedia;
    }

    public void setDescriptionMultimedia(String descriptionMultimedia) {
        this.descriptionMultimedia = descriptionMultimedia;
    }

    public int getIdPublication() {
        return idPublication;
    }

    public void setIdPublication(int idPublication) {
        this.idPublication = idPublication;
    }
}
