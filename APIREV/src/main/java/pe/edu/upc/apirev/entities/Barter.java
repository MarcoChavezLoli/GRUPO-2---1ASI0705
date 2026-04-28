package pe.edu.upc.apirev.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Barter")
public class Barter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBarter;
    @Column(name = "BarterDescriotion",length = 200,nullable = false)
    private String barterDescrition;

}
