package pe.edu.upc.apirev.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.apirev.repositories.IItemRepository;
import pe.edu.upc.apirev.repositories.IRecyclingRepository;
import pe.edu.upc.apirev.servicesinterfaces.IRecyclingService;

@Service
public class RecyclingServiceImplement implements IRecyclingService {

    @Autowired
    public IRecyclingRepository rR;
}
