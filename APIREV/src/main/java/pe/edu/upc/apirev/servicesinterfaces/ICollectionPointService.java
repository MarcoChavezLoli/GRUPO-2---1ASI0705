package pe.edu.upc.apirev.servicesinterfaces;


import pe.edu.upc.apirev.entities.CollectionPoint;
import java.util.List;

public interface ICollectionPointService {
    public void insert(CollectionPoint collectionPoint);
    public List<CollectionPoint> list();
    public void delete(int idCollectionPoint);
    public CollectionPoint listId(int idCollectionPoint);
    public void update(CollectionPoint collectionPoint);
}

public interface ICollectionPointService {
}

