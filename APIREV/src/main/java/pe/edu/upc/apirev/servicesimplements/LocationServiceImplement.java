package pe.edu.upc.apirev.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.apirev.entities.Location;
import pe.edu.upc.apirev.repositories.ILocationRepository;
import pe.edu.upc.apirev.servicesinterfaces.ILocationService;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImplement implements ILocationService {
    @Autowired
    private ILocationRepository lR;

    @Override

    public List<Location> list (){return lR.findAll();}

    @Override
    public Location insert(Location l) {
        return lR.save(l);
    }

    @Override
    public Optional<Location> listId(int id) {
        return lR.findById(id);
    }

    @Override
    public void update(Location l) {
        lR.save(l);

    }

    @Override
    public void delete(int id) {
        lR.deleteById(id);

    }

}
