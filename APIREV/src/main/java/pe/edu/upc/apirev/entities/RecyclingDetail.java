package pe.edu.upc.apirev.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "RecyclingDetail")
public class RecyclingDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int RecyclingDetailsId;

    @Column (name = "DescripcionDetail",length = 200, nullable = false)
    private String DescripcionDetail;

    @Column (name = "RegistrationDate",length = 200, nullable = false)
    private LocalDate RegistrationDate;

    @Column (name = "TraceabilityStatus",length = 200, nullable = false)
    private String TraceabilityStatus;

    @ManyToOne
    @JoinColumn(name = "idCollectionPoint")
    private CollectionPoint collectionPoint;

    public RecyclingDetail() {
    }

    public RecyclingDetail(int recyclingDetailsId, String descripcionDetail, LocalDate registrationDate, String traceabilityStatus, CollectionPoint collectionPoint) {
        RecyclingDetailsId = recyclingDetailsId;
        DescripcionDetail = descripcionDetail;
        RegistrationDate = registrationDate;
        TraceabilityStatus = traceabilityStatus;
        this.collectionPoint = collectionPoint;
    }

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

    public CollectionPoint getCollectionPoint() {
        return collectionPoint;
    }

    public void setCollectionPoint(CollectionPoint collectionPoint) {
        this.collectionPoint = collectionPoint;
    }
}
