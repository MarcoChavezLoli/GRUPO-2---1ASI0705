package pe.edu.upc.apirev.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.apirev.entities.Item;
import pe.edu.upc.apirev.repositories.IItemRepository;
import pe.edu.upc.apirev.servicesinterfaces.IItemService;

import java.util.List;

@Service
public class ItemServiceImplement implements IItemService {

    @Autowired
    public IItemRepository iR;

    @Override
    public List<Item> listar() {
        return iR.findAll();
    }
}
