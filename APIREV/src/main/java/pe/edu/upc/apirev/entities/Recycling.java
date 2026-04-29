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
    @JoinColumn(name = "MaterialId")
    private Material material;


    @ManyToOne
    @JoinColumn(name = "idUser")
     private User Usuario;


    public Recycling() {}

    public Recycling(int recyclingId, String recyclingName, Material material, User usuario) {
        RecyclingId = recyclingId;
        RecyclingName = recyclingName;
        this.material = material;
        Usuario = usuario;
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

    public User getUsuario() {
        return Usuario;
    }

    public void setUsuario(User usuario) {
        Usuario = usuario;
    }
}
