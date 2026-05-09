package pe.edu.upc.apirev.servicesinterfaces;

import pe.edu.upc.apirev.entities.Barter;

import java.util.List;
import java.util.Optional;

public interface IBarterService {
    public List<Barter> list();
    public Barter insert (Barter b);
    public void update (Barter b);
    public void delete (int id);
    public Optional<Barter> listId(int id);
    public List<Object[]> findAllBartersWithUsers();
}
