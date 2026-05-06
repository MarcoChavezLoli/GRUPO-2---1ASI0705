package pe.edu.upc.apirev.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.apirev.entities.Donacion;
import pe.edu.upc.apirev.repositories.IDonacionRepository;
import pe.edu.upc.apirev.servicesinterfaces.IDonacionService;

import java.util.List;

@Service
public class DonacionServiceImplement implements IDonacionService {

    @Autowired
    private IDonacionRepository Dr;


    @Override
    public Donacion insert(Donacion d) {
        return Dr.save(d);
    }

    @Override
    public List<Donacion> list() {
        return Dr.findAll();
    }

    @Override
    public void update(Donacion d) {
        Dr.save(d);
    }

    @Override
    public void delete(int id) {
        Dr.deleteById(id);
    }
}
