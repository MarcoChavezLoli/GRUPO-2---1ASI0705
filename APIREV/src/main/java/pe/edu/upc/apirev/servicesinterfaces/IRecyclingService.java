package pe.edu.upc.apirev.servicesinterfaces;

import pe.edu.upc.apirev.entities.Category;
import pe.edu.upc.apirev.entities.Item;
import pe.edu.upc.apirev.entities.Location;
import pe.edu.upc.apirev.entities.Recycling;

import java.util.List;
import java.util.Optional;

public interface IRecyclingService {

    public List<Recycling> list ();
    public Recycling insert(Recycling r);
    public Optional<Recycling> ListId(int id);
    public void delete(int id);
    public void Update(Recycling r);
    List<Object[]> quantityRecyclingNative();

}
