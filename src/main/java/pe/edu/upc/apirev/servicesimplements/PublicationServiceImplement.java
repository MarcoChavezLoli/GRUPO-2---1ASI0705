package pe.edu.upc.apirev.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.apirev.entities.Publication;
import pe.edu.upc.apirev.repositories.IPublicationRepository;
import pe.edu.upc.apirev.servicesinterfaces.IPublicationService;

import java.util.List;

@Service
public class PublicationServiceImplement implements IPublicationService {
    @Autowired
    private IPublicationRepository pRep;

    @Override
    public List<Publication> list() {
        return pRep.findAll();
    }
}
