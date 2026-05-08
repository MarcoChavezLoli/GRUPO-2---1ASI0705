package pe.edu.upc.apirev.entities;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.time.LocalDate;

@Entity
@Table(name="Chat")
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idchat;
    @Column(name="Contenido",length = 25, nullable = false)
    private String chatcontenido;
    @Column(name="fechaenvio",length = 25,nullable = false)
    private LocalDate chatfechaenvio;
    @Column(name="Estado",nullable = false)
    private boolean chatstatus;

    @ManyToOne
    @JoinColumn(name="iduser")
    private User idUser;

    @ManyToOne
    @JoinColumn(name="iduser")
    private User idUser2;

    public Chat() {
    }

    public Chat(int idchat, String chatcontenido, LocalDate chatfechaenvio, boolean chatstatus, User idUser) {
        this.idchat = idchat;
        this.chatcontenido = chatcontenido;
        this.chatfechaenvio = chatfechaenvio;
        this.chatstatus = chatstatus;
        this.idUser = idUser;
    }

    public int getIdchat() {
        return idchat;
    }

    public void setIdchat(int idchat) {
        this.idchat = idchat;
    }

    public String getChatcontenido() {
        return chatcontenido;
    }

    public void setChatcontenido(String chatcontenido) {
        this.chatcontenido = chatcontenido;
    }

    public LocalDate getChatfechaenvio() {
        return chatfechaenvio;
    }

    public void setChatfechaenvio(LocalDate chatfechaenvio) {
        this.chatfechaenvio = chatfechaenvio;
    }

    public boolean isChatstatus() {
        return chatstatus;
    }

    public void setChatstatus(boolean chatstatus) {
        this.chatstatus = chatstatus;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    public User getIdUser2() {
        return idUser2;
    }

    public void setIdUser2(User idUser2) {
        this.idUser2 = idUser2;
    }
}
