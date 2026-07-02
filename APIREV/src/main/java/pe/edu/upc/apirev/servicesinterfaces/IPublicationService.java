package pe.edu.upc.apirev.servicesinterfaces;

import pe.edu.upc.apirev.entities.Publication;

import java.util.List;
import java.util.Optional;

public interface IPublicationService {
    public List<Publication> list();
    public Publication insert(Publication p);
    public Optional<Publication> listId(int id);
    public void update(Publication p);
    public void delete(int id);
    List<Object[]> quantityPublicationsByUser();
    
}
