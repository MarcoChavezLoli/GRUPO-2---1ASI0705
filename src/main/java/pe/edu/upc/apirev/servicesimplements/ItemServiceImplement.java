package pe.edu.upc.apirev.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.apirev.repositories.IItemRepository;
import pe.edu.upc.apirev.servicesinterfaces.IItemService;

@Service
public class ItemServiceImplement implements IItemService {

    @Autowired
    public IItemRepository iR;
}
