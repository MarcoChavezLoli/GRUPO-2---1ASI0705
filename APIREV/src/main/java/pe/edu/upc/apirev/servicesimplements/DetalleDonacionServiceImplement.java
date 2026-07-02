package pe.edu.upc.apirev.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.apirev.entities.DetalleDonacion;
import pe.edu.upc.apirev.repositories.IDetalleDonacionRepository;
import pe.edu.upc.apirev.servicesinterfaces.IDetalleDonacionService;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleDonacionServiceImplement implements IDetalleDonacionService {

    @Autowired
    private IDetalleDonacionRepository Ddr;


    @Override
    public DetalleDonacion insert(DetalleDonacion dd) {
        return Ddr.save(dd);
    }

    @Override
    public List<DetalleDonacion> list() {
        return Ddr.findAll();
    }

    @Override
    public void update(DetalleDonacion dd) {
        Ddr.save(dd);
    }

    @Override
    public void delete(int id) {
        Ddr.deleteById(id);
    }

    @Override
    public Optional<DetalleDonacion> listid(int id) {
        return Ddr.findById(id);
    }
}
