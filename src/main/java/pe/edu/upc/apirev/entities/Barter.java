package pe.edu.upc.apirev.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Barter")
public class Barter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBarter;
    @Column(name = "DescriptionBarter",length = 200,nullable = false)
    private String DescriptionBarter;
    @Column(name = "StatusBarter",nullable = false)
    private boolean StatusBarter;
    @Column(name = "DateBarter", nullable = false)
    private LocalDate DateBarter;
    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;

    public Barter(int idBarter, String descriptionBarter, boolean statusBarter, LocalDate dateBarter, User user) {
        this.idBarter = idBarter;
        this.DescriptionBarter = descriptionBarter;
        this.StatusBarter = statusBarter;
        this.DateBarter = dateBarter;
        this.user = user;
    }
    public Barter() {

    }

    public int getIdBarter() {
        return idBarter;
    }

    public void setIdBarter(int idBarter) {
        this.idBarter = idBarter;
    }

    public String getDescriptionBarter() {
        return DescriptionBarter;
    }

    public void setDescriptionBarter(String descriptionBarter) {
        DescriptionBarter = descriptionBarter;
    }

    public boolean isStatusBarter() {
        return StatusBarter;
    }

    public void setStatusBarter(boolean statusBarter) {
        StatusBarter = statusBarter;
    }

    public LocalDate getDateBarter() {
        return DateBarter;
    }

    public void setDateBarter(LocalDate dateBarter) {
        DateBarter = dateBarter;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
