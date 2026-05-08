package pe.edu.upc.apirev.dtos;
import pe.edu.upc.apirev.entities.Item;
import java.time.LocalDate;

public class DetalleDonacionDTO {

    private int iddetalledonacion;
    private String descripciondetalle;
    private LocalDate fecharegistrada;
    private boolean estadotrazabilidad;
    private Item Itemid;

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

    public boolean getEstadotrazabilidad() {
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
