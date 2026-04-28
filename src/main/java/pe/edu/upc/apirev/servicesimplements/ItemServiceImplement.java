package pe.edu.upc.apirev.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.apirev.entities.Item;
import pe.edu.upc.apirev.repositories.IItemRepository;
import pe.edu.upc.apirev.servicesinterfaces.IItemService;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImplement implements IItemService {

    @Autowired
    public IItemRepository iR;

    @Override
    public List<Item> listar() {
        return iR.findAll();
    }

    @Override
    public Item insert(Item item) {
        return iR.save(item);
    }

    @Override
    public Optional<Item> ListId(int id) {
        return iR.findById(id);
    }

    @Override
    public void Delete(int id) {
        iR.deleteById(id);
    }

    @Override
    public void Update(Item i) {
        iR.save(i);
    }
}
