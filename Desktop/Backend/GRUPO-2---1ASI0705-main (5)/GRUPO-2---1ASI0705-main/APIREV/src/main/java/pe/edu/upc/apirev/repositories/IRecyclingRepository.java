package pe.edu.upc.apirev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.apirev.entities.Recycling;

import java.util.List;

@Repository
public interface IRecyclingRepository extends JpaRepository<Recycling,Integer> {


    @Query(value = "SELECT u.id_user, u.user_name, COUNT(r.recycling_id)\n" +
            "FROM users u \n" +
            "LEFT JOIN recycling r ON u.id_user = r.id_user\n" +
            "GROUP BY u.id_user, u.user_name",
            nativeQuery = true)
    List<Object[]> quantityRecyclingByUser();
}