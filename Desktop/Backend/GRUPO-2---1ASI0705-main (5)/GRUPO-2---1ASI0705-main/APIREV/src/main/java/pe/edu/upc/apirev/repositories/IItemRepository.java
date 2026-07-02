package pe.edu.upc.apirev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.apirev.entities.Item;

import java.util.List;

@Repository
public interface IItemRepository extends JpaRepository<Item,Integer> {

    @Query(value = "SELECT c.id_category, c.name_category, COUNT(a.item_id) " +
            " FROM category c " +
            " INNER JOIN item a" +
            " ON c.id_category = a.id_category " +
            "GROUP BY c.id_category, c.name_category",
            nativeQuery = true)
    List<Object[]> quantityItemByCategory();
}
