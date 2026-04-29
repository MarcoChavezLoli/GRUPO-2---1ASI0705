package pe.edu.upc.apirev.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Material")
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int MaterialId;

    @Column (name = "MaterialType",length = 100, nullable = false)
    private String MaterialType;

    public Material() {
    }

    public Material(int materialId, String materialType) {
        MaterialId = materialId;
        MaterialType = materialType;
    }

    public int getMaterialId() {
        return MaterialId;
    }

    public void setMaterialId(int materialId) {
        MaterialId = materialId;
    }

    public String getMaterialType() {
        return MaterialType;
    }

    public void setMaterialType(String materialType) {
        MaterialType = materialType;
    }
}
