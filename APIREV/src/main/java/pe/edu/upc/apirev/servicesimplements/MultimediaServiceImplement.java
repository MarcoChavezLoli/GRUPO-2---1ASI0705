package pe.edu.upc.apirev.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.apirev.entities.Multimedia;
import pe.edu.upc.apirev.repositories.IMultimediaRepository;
import pe.edu.upc.apirev.servicesinterfaces.IMultimediaService;
import java.util.List;
import java.util.Optional;

@Service
public class MultimediaServiceImplement implements IMultimediaService {
    @Autowired
    private IMultimediaRepository mR;

    @Override
    public List<Multimedia> list() {
        return mR.findAll();

    }

    @Override
    public Optional<Multimedia> listId(int id) {
        return mR.findById(id);
    }

    @Override
    public void delete(int id) {
        mR.deleteById(id);
    }

    @Override
    public Multimedia insert(Multimedia m) {
        return mR.save(m);
    }

    @Override
    public Multimedia update(Multimedia m) {
        return mR.save(m);
    }
}
