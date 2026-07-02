package pe.edu.upc.apirev.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;

    @Column(name = "ItemName", length = 50,nullable = false)
    private String ItemName;

    @Column(name = "ItemDescription", length = 100,nullable = false)
    private String ItemDescription;

    @Column(name = "ItemCondition", length = 50,nullable = false)
    private String ItemCondition;


    @ManyToOne
    @JoinColumn(name = "IdCategory")
    private Category category;


    public Item() {}

    public Item(int itemId, String itemName, String itemDescription, String itemCondition, Category category) {
        this.itemId = itemId;
        ItemName = itemName;
        ItemDescription = itemDescription;
        ItemCondition = itemCondition;
        this.category = category;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public String getItemDescription() {
        return ItemDescription;
    }

    public void setItemDescription(String itemDescription) {
        ItemDescription = itemDescription;
    }

    public String getItemCondition() {
        return ItemCondition;
    }

    public void setItemCondition(String itemCondition) {
        ItemCondition = itemCondition;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
