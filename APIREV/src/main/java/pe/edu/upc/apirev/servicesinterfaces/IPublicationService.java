package pe.edu.upc.apirev.servicesinterfaces;

import pe.edu.upc.apirev.entities.Publication;

import java.util.List;

public interface IPublicationService {
    public List<Publication> list();
    public Publication insert(Publication pu);
    
}
