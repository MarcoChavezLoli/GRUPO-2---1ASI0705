package pe.edu.upc.apirev.dtos;

import pe.edu.upc.apirev.entities.Item;

import java.time.LocalDate;

public class DonationDetailDTO {
    private int idDonationDetail;
    private String detailDescription;
    private LocalDate dateRegistration;
    private boolean traceabilityStatus;
    private int itemId;

    public int getIdDonationDetail() {
        return idDonationDetail;
    }

    public void setIdDonationDetail(int idDonationDetail) {
        this.idDonationDetail = idDonationDetail;
    }

    public String getDetailDescription() {
        return detailDescription;
    }

    public void setDetailDescription(String detailDescription) {
        this.detailDescription = detailDescription;
    }

    public LocalDate getDateRegistration() {
        return dateRegistration;
    }

    public void setDateRegistration(LocalDate dateRegistration) {
        this.dateRegistration = dateRegistration;
    }

    public boolean isTraceabilityStatus() {
        return traceabilityStatus;
    }

    public void setTraceabilityStatus(boolean traceabilityStatus) {
        this.traceabilityStatus = traceabilityStatus;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
}
