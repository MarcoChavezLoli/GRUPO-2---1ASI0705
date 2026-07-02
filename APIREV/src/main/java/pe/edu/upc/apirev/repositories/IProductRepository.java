package pe.edu.upc.apirev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.apirev.entities.Product;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product,Integer> {
    @Query(value = "SELECT c.id_category, c.name_category, COUNT(p.id_product) AS total_productos " +
            "FROM category c " +
            "LEFT JOIN product p ON c.id_category = p.id_category " +
            "GROUP BY c.id_category, c.name_category " +
            "ORDER BY total_productos DESC", nativeQuery = true)
    List<Object[]> countProductsByCategory();

}
