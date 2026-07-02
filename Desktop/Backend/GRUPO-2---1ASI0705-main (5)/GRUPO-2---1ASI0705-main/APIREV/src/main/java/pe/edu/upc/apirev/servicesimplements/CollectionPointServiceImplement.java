package pe.edu.upc.apirev.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.apirev.entities.CollectionPoint;
import pe.edu.upc.apirev.repositories.ICollectionPointRepository;
import pe.edu.upc.apirev.servicesinterfaces.ICollectionPointService;

import java.util.List;
import java.util.Optional;

@Service
public class CollectionPointServiceImplement implements ICollectionPointService {

    @Autowired
    private ICollectionPointRepository cpR;

    @Override
    public CollectionPoint insert(CollectionPoint collectionPoint) {
        return cpR.save(collectionPoint);
    }

    @Override
    public List<CollectionPoint> list() {
        return cpR.findAll();
    }

    @Override
    public void delete(int idCollectionPoint) {
        cpR.deleteById(idCollectionPoint);
    }

    @Override
    public Optional<CollectionPoint> listId(int idCollectionPoint) {
        return cpR.findById(idCollectionPoint);
    }

    @Override
    public void update(CollectionPoint collectionPoint) {
        cpR.save(collectionPoint);
    }
    
    @Override
    public List<Object[]> countPointsByAddressNative() {
        return cpR.countPointsByAddressNative();
    }
}