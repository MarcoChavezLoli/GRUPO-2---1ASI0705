package pe.edu.upc.apirev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.apirev.entities.Donation;

import java.util.List;

@Repository
public interface IDonationRepository extends JpaRepository<Donation,Integer> {
    @Query(value = "SELECT u.user_name,\n" +
            "COUNT(d.id_donation)\n" +
            "FROM donation d\n" +
            "INNER JOIN users u\n" +
            "ON d.id_user = u.id_user\n" +
            "GROUP BY u.user_name", nativeQuery = true)
    List<Object[]> quantityDonationUser();

    @Query(value = "SELECT\n" +
            "i.item_condition,\n" +
            "COUNT(d.id_donation)\n" +
            "FROM donation d\n" +
            "INNER JOIN item i\n" +
            "ON d.item_id = i.item_id\n" +
            "GROUP BY i.item_condition", nativeQuery = true)
    List<Object[]> donationCondition();
}
