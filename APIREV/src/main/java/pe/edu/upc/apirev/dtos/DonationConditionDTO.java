package pe.edu.upc.apirev.dtos;

public class DonationConditionDTO {

    private String condition;
    private int quantity;

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
