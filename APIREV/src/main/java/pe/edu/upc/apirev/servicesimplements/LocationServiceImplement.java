package pe.edu.upc.apirev.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.apirev.entities.Location;
import pe.edu.upc.apirev.entities.Role;
import pe.edu.upc.apirev.repositories.ILocationRepository;
import pe.edu.upc.apirev.servicesinterfaces.ILocationService;

import java.util.List;

@Service

public class LocationServiceImplement implements ILocationService {
    @Autowired
    private ILocationRepository lR;

    @Override

    public List<Location> list (){return lR.findAll();}

}
