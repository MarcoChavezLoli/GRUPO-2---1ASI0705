package pe.edu.upc.apirev.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="DetalleDonacion")
public class DetalleDonacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int iddetalledonacion;
    @Column(name="descripciondetalle",length = 25,nullable = false)
    private String descripciondetalle;
    @Column(name="fecharegistrada",length = 25,nullable = false)
    private LocalDate fecharegistrada;
    @Column(name="estadotrazabilidad",length = 25,nullable = false)
    private boolean estadotrazabilidad;

    @ManyToOne
    @JoinColumn(name="idarticulo")
    private Item Itemid;

    public DetalleDonacion() {
    }

    public DetalleDonacion(int iddetalledonacion, String descripciondetalle, LocalDate fecharegistrada, boolean estadotrazabilidad, Item itemid) {
        this.iddetalledonacion = iddetalledonacion;
        this.descripciondetalle = descripciondetalle;
        this.fecharegistrada = fecharegistrada;
        this.estadotrazabilidad = estadotrazabilidad;
        Itemid = itemid;
    }

    public int getIddetalledonacion() {
        return iddetalledonacion;
    }

    public void setIddetalledonacion(int iddetalledonacion) {
        this.iddetalledonacion = iddetalledonacion;
    }

    public String getDescripciondetalle() {
        return descripciondetalle;
    }

    public void setDescripciondetalle(String descripciondetalle) {
        this.descripciondetalle = descripciondetalle;
    }

    public LocalDate getFecharegistrada() {
        return fecharegistrada;
    }

    public void setFecharegistrada(LocalDate fecharegistrada) {
        this.fecharegistrada = fecharegistrada;
    }

    public boolean isEstadotrazabilidad() {
        return estadotrazabilidad;
    }

    public void setEstadotrazabilidad(boolean estadotrazabilidad) {
        this.estadotrazabilidad = estadotrazabilidad;
    }

    public Item getItemid() {
        return Itemid;
    }

    public void setItemid(Item itemid) {
        Itemid = itemid;
    }
}
