package pe.edu.upc.apirev.dtos;

import pe.edu.upc.apirev.entities.User;

import java.time.LocalDate;

public class ChatDTO {

    private int idchat;
    private String chatcontenido;
    private LocalDate chatfechaenvio;
    private boolean chatstatus;
    private User idUser;
    private User idUser2;

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

    public boolean getChatstatus() {
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
