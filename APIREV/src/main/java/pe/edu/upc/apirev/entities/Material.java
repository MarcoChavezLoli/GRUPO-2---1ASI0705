package pe.edu.upc.apirev.entities;

import jakarta.persistence.*;

@Entity

@Table(name = "materials")
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMaterial;

    @Column(name = "MaterialName", length = 100, nullable = false)
    private String MaterialName;

    @Column(name = "MaterialDescription", length = 250, nullable = false)
    private String MaterialDescription;

    @Column(name = "MaterialType", length = 100, nullable = false)
    private String MaterialType;

    public Material(int idMaterial, String materialName, String materialDescription, String materialType) {
        this.idMaterial = idMaterial;
        this.MaterialName = materialName;
        this.MaterialDescription = materialDescription;
        this.MaterialType = materialType;
    }

    public Material() {
    }

    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getMaterialName() {
        return MaterialName;
    }

    public void setMaterialName(String materialName) {
        MaterialName = materialName;
    }

    public String getMaterialDescription() {
        return MaterialDescription;
    }

    public void setMaterialDescription(String materialDescription) {
        MaterialDescription = materialDescription;

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


