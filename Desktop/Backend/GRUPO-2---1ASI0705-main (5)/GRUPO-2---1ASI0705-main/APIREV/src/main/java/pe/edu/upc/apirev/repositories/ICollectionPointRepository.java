package pe.edu.upc.apirev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.apirev.entities.CollectionPoint;

import java.util.List;

@Repository
public interface ICollectionPointRepository extends JpaRepository<CollectionPoint, Integer> {
@Query(value = "SELECT collection_point_address, COUNT(id_collection_point) " +
                   "FROM collection_point " +
                   "GROUP BY collection_point_address", 
           nativeQuery = true)
    List<Object[]> countPointsByAddressNative();
}
