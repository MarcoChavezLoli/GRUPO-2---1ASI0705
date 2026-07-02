package pe.edu.upc.apirev.servicesinterfaces;


import pe.edu.upc.apirev.entities.CollectionPoint;
import java.util.List;
import java.util.Optional;

public interface ICollectionPointService {
    public CollectionPoint insert(CollectionPoint collectionPoint);
    public List<CollectionPoint> list();
    public void delete(int idCollectionPoint);
    public Optional<CollectionPoint> listId(int idCollectionPoint);
    public void update(CollectionPoint collectionPoint);

    List<Object[]> countPointsByAddressNative();
}
