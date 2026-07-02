package pe.edu.upc.apirev.dtos;


import java.time.LocalDate;

public class RecyclingDetailDTO {

    private int recyclingDetailsId;
    private String descriptionDetail;
    private LocalDate registrationDate;
    private String traceabilityStatus;
    private int collectionPointId;
    private int recyclingId;

    public int getRecyclingDetailsId() {
        return recyclingDetailsId;
    }

    public void setRecyclingDetailsId(int recyclingDetailsId) {
        this.recyclingDetailsId = recyclingDetailsId;
    }

    public String getDescriptionDetail() {
        return descriptionDetail;
    }

    public void setDescriptionDetail(String descriptionDetail) {
        this.descriptionDetail = descriptionDetail;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getTraceabilityStatus() {
        return traceabilityStatus;
    }

    public void setTraceabilityStatus(String traceabilityStatus) {
        this.traceabilityStatus = traceabilityStatus;
    }

    public int getCollectionPointId() {
        return collectionPointId;
    }

    public int getRecyclingId() {
        return recyclingId;
    }

    public void setRecyclingId(int recyclingId) {
        this.recyclingId = recyclingId;
    }

    public void setCollectionPointId(int collectionPointId) {
        this.collectionPointId = collectionPointId;
    }
}
