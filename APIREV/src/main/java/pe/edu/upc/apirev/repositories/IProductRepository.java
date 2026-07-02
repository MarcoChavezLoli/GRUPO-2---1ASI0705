package pe.edu.upc.apirev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.apirev.entities.Product;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product,Integer> {
    @Query(value = "SELECT p.id_product, p.conservation_status, p.name_product, p.id_barter, p.id_category " +
            "FROM product p " +
            "INNER JOIN category c ON p.id_category = c.id_category " +
            "WHERE c.name_category = :nameCategory", nativeQuery = true)
    List<Object[]> findProductsByCategory(@Param("nameCategory") String nameCategory);

}
