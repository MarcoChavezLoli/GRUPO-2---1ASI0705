package pe.edu.upc.apirev.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.apirev.entities.Multimedia;
import pe.edu.upc.apirev.repositories.IMultimediaRepository;
import pe.edu.upc.apirev.servicesinterfaces.IMultimediaService;

import java.util.List;

@Service
public class MultimediaServiceImplement implements IMultimediaService {
    @Autowired
    private IMultimediaRepository mR;

    @Override
    public List<Multimedia> list() {
        return mR.findAll();
    }
}
