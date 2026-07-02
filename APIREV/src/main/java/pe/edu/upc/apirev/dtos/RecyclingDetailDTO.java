package pe.edu.upc.apirev.dtos;


import java.time.LocalDate;

public class RecyclingDetailDTO {

    private int RecyclingDetailsId;
    private String DescripcionDetail;
    private LocalDate RegistrationDate;
    private String TraceabilityStatus;
    private int CollectionPointId;

    public int getRecyclingDetailsId() {
        return RecyclingDetailsId;
    }

    public void setRecyclingDetailsId(int recyclingDetailsId) {
        RecyclingDetailsId = recyclingDetailsId;
    }

    public String getDescripcionDetail() {
        return DescripcionDetail;
    }

    public void setDescripcionDetail(String descripcionDetail) {
        DescripcionDetail = descripcionDetail;
    }

    public LocalDate getRegistrationDate() {
        return RegistrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        RegistrationDate = registrationDate;
    }

    public String getTraceabilityStatus() {
        return TraceabilityStatus;
    }

    public void setTraceabilityStatus(String traceabilityStatus) {
        TraceabilityStatus = traceabilityStatus;
    }

    public int getCollectionPointId() {
        return CollectionPointId;
    }

    public void setCollectionPointId(int collectionPointId) {
        CollectionPointId = collectionPointId;
    }
}
