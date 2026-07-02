package pe.edu.upc.apirev.servicesimplements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.apirev.entities.PublicationSave;
import pe.edu.upc.apirev.repositories.IPublicationSaveRepository;
import pe.edu.upc.apirev.servicesinterfaces.IPublicationSaveService;

@Service
public class PublicationSaveImplements implements IPublicationSaveService {

    @Autowired
    private IPublicationSaveRepository ipublicationsaveRepository;

    @Override
    public List<PublicationSave> list() {
        return ipublicationsaveRepository.findAll();
    }

    @Override
    public PublicationSave insert(PublicationSave publicationSave) {
        return ipublicationsaveRepository.save(publicationSave);
    }

    @Override
    public void delete(int idPublicationSave) {
        ipublicationsaveRepository.deleteById(idPublicationSave);
    }

    @Override
    public Optional<PublicationSave> listId(int idPublicationSave) {
        return ipublicationsaveRepository.findById(idPublicationSave);
    }

    @Override
    public PublicationSave update(PublicationSave p) {
        return ipublicationsaveRepository.save(p);
    }

}
