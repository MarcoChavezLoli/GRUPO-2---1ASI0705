package pe.edu.upc.apirev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.apirev.entities.Publication;

import java.util.List;

@Repository
public interface IPublicationRepository  extends JpaRepository<Publication,Integer> {

    @Query(value = "SELECT u.id_user, u.user_name, COUNT(pub.id_publication) AS total_publicaciones " +
            "FROM users u " +
            "LEFT JOIN publication pub ON u.id_user = pub.id_user " +
            "GROUP BY u.id_user, u.user_name " +
            "ORDER BY total_publicaciones DESC",
            nativeQuery = true)
    List<Object[]> quantityPublicationsByUser();

}

