package pe.edu.upc.apirev.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.apirev.entities.Publication;
import pe.edu.upc.apirev.repositories.IPublicationRepository;
import pe.edu.upc.apirev.servicesinterfaces.IPublicationService;

import java.util.List;
import java.util.Optional;
@Service
public class PublicationServiceImplement implements IPublicationService {
    @Autowired
    private IPublicationRepository pbR;

    @Override
    public List<Publication> list() {
        return pbR.findAll();
    }

    @Override
    public Publication insert(Publication p) {
        return pbR.save(p);
    }

    @Override
    public Optional<Publication> listId(int id) {
        return pbR.findById(id);
    }

    @Override
    public void update(Publication p) { pbR.save(p);

    }

    @Override
    public void delete(int id) { pbR.deleteById(id);

    }

    @Override
    public List<Object[]> quantityPublicationsByUser() {
        return pbR.quantityPublicationsByUser();
    }

}
