package pe.edu.upc.apirev.entities;

import jakarta.persistence.*;

@Entity
@Table(name="Donacion")
public class Donacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int iddonacion;
    @Column(name="",length = 25,nullable = false)
    private String namedonacion;


}
