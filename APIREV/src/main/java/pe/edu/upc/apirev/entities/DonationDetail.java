package pe.edu.upc.apirev.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name="DonationDetail")
public class DonationDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDonationDetail;

    @Column(name="DetailDescription",length = 25,nullable = false)
    private String DetailDescription;

    @Column(name="DateRegistration",nullable = false)
    private LocalDate DateRegistration;

    @Column(name="TraceabilityStatus",nullable = false)
    private boolean TraceabilityStatus;

    @ManyToOne
    @JoinColumn(name="ItemId")
    private Item Item;

    public DonationDetail() {
    }

    public DonationDetail(int idDonationDetail, String detailDescription, LocalDate dateRegistration, boolean traceabilityStatus, Item item) {
        this.idDonationDetail = idDonationDetail;
        DetailDescription = detailDescription;
        DateRegistration = dateRegistration;
        TraceabilityStatus = traceabilityStatus;
        Item = item;
    }

    public int getIdDonationDetail() {
        return idDonationDetail;
    }

    public void setIdDonationDetail(int idDonationDetail) {
        this.idDonationDetail = idDonationDetail;
    }

    public String getDetailDescription() {
        return DetailDescription;
    }

    public void setDetailDescription(String detailDescription) {
        DetailDescription = detailDescription;
    }

    public LocalDate getDateRegistration() {
        return DateRegistration;
    }

    public void setDateRegistration(LocalDate dateRegistration) {
        DateRegistration = dateRegistration;
    }

    public boolean isTraceabilityStatus() {
        return TraceabilityStatus;
    }

    public void setTraceabilityStatus(boolean traceabilityStatus) {
        TraceabilityStatus = traceabilityStatus;
    }

    public Item getItem() {
        return Item;
    }

    public void setItem(Item item) {
        Item = item;
    }
}