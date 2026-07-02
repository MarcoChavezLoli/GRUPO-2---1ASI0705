package pe.edu.upc.apirev.servicesinterfaces;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.apirev.entities.PublicationSave;

public interface IPublicationSaveService {
    public List<PublicationSave> list();

    public PublicationSave insert(PublicationSave p);

    public Optional<PublicationSave> listId(int id);

    public PublicationSave update(PublicationSave p);

    public void delete(int id);

}
