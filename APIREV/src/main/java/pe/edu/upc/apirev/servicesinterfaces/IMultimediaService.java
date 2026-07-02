package pe.edu.upc.apirev.servicesinterfaces;

import pe.edu.upc.apirev.entities.Multimedia;

import java.util.List;
import java.util.Optional;

public interface IMultimediaService {
    public List<Multimedia> list();

    public Optional<Multimedia> listId(int id);

    public void delete(int id);

    public Multimedia insert(Multimedia m);

    public Multimedia update(Multimedia m);
}
