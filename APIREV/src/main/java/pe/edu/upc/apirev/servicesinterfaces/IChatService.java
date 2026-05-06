package pe.edu.upc.apirev.servicesinterfaces;

import pe.edu.upc.apirev.entities.Chat;

import java.util.List;

public interface IChatService {

    public Chat insert(Chat c);
    public List<Chat> list();
    public void update(Chat c);
    public void delete (int id);

}
