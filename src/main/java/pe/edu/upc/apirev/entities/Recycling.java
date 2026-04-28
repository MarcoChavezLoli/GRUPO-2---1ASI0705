package pe.edu.upc.apirev.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "Reciclaje")
public class Recycling {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int RecyclingId;

    @Column (name = "RecyclingName",length = 50, nullable = false)
    private String RecyclingName;

    //@ManyToOne
    // @JoinColumn(name = "MaterialId")
    //private Material material;


    //@ManyToOne
    // @JoinColumn(name = "UserId")
    // private User Usuario;


    public Recycling() {}

    public Recycling(int recyclingId, String recyclingName) {
        RecyclingId = recyclingId;
        RecyclingName = recyclingName;
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
}
