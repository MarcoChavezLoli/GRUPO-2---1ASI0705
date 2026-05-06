package pe.edu.upc.apirev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.apirev.entities.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User,Integer> {
    @Query(value = "select u.id_user, u.user_name, u.user_email, u.user_registration_date\n" +
            " from users u\n" +
            " left join barter b on u.id_user = b.id_user\n" +
            " where b.id_barter is null\n" +
            " order by u.user_registration_date desc", nativeQuery = true)
    List<Object[]> usersWithoutBarter();

    Optional<User> findByUserEmail(String userEmail);
}
