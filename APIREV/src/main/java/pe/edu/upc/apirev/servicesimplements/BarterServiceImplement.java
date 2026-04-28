package pe.edu.upc.apirev.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.apirev.repositories.IBarterRepository;
import pe.edu.upc.apirev.servicesinterfaces.IBarterService;

@Service
public class BarterServiceImplement implements IBarterService {
    @Autowired
    private  IBarterRepository bR;
}
