package pe.edu.upc.apirev.servicesinterfaces;

import pe.edu.upc.apirev.entities.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    public List<User> list();
    public User insert (User u);
    public void update(User u);
    public Optional<User> listId(int id);
    public void delete(int id);
}
