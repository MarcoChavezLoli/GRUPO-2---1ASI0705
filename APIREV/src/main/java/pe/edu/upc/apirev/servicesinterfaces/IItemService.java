package pe.edu.upc.apirev.servicesinterfaces;

import pe.edu.upc.apirev.entities.Item;

import java.util.List;
import java.util.Optional;

public interface IItemService {

    public List<Item> listar();
    public Item insert(Item item);
    public Optional<Item> ListId(int id);
    public void Delete(int id);
    public void Update(Item i);
    List<Object[]>quantityItemNative();
}