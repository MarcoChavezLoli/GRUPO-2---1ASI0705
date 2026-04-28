package pe.edu.upc.apirev.servicesinterfaces;

import pe.edu.upc.apirev.entities.Location;
import pe.edu.upc.apirev.entities.Role;

import java.util.List;
import java.util.Optional;

public interface ILocationService {
    public List<Location> list ();
    public Location insert(Location l);
    public Optional<Location> listId(int id);
    public void update(Location l);
    public void delete(int id);

}
