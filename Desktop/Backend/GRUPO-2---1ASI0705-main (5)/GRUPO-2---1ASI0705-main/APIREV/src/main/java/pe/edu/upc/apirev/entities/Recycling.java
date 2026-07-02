package pe.edu.upc.apirev.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "Recycling")
public class Recycling {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int RecyclingId;

    @Column (name = "RecyclingName",length = 50, nullable = false)
    private String RecyclingName;

    @ManyToOne
    @JoinColumn(name = "idMaterial")
    private Material material;


    @ManyToOne
    @JoinColumn(name = "idUser")
     private User user;


    public Recycling() {}

    public Recycling(int recyclingId, String recyclingName, Material material, User user) {
        RecyclingId = recyclingId;
        RecyclingName = recyclingName;
        this.material = material;
        this.user = user;
    }

    public int getRecyclingId() {
        return RecyclingId;
    }

    public void setRecyclingId(int recyclingId) {
        RecyclingId = recyclingId;
    }

    public String getRecyclingName() {
        return RecyclingName;
    }

    public void setRecyclingName(String recyclingName) {
        RecyclingName = recyclingName;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
