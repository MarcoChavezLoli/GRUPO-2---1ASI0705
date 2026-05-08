package pe.edu.upc.apirev.servicesimplements;

import pe.edu.upc.apirev.servicesinterfaces.IPublicationSaveService;

public class PublicationSaveImplements implements IPublicationSaveService {
    @Autowired
    private IPublicationSaveRepository ipublicationsaveRepository;

    @Override
    public List<PublicationSave> list() {
        return ipublicationsaveRepository.findAll();
    }

    @Override
    public void insert(PublicationSave publicationSave) {
        ipublicationsaveRepository.save(publicationSave);
    }

    @Override
    public void delete(int idPublicationSave) {
        ipublicationsaveRepository.deleteById(idPublicationSave);
    }

    @Override
    public PublicationSave findById(int idPublicationSave) {
        return ipublicationsaveRepository.findById(idPublicationSave).orElse(null);
    }

    @GetMapping("/listByUser/{idUser}")
    public List<PublicationSave> listByUser(@PathVariable int idUser) {
        return ipublicationsaveRepository.findByUser(idUser);
    }
}
