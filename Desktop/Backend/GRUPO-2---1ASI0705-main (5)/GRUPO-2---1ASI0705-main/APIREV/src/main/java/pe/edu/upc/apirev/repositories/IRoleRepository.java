package pe.edu.upc.apirev.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.apirev.entities.Role;

import java.util.List;
@Repository
public interface IRoleRepository extends JpaRepository<Role,Integer> {
    @Query(value = "select r.name_role,\n" +
            " count (u.id_user) as cantidad_usuarios\n" +
            " from roles r\n" +
            " left join users u on r.user_id = u.id_user\n" +
            " group by r.name_role\n" +
            " order by cantidad_usuarios desc",nativeQuery = true)
    List<Object[]> quantityRoleByUser();
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM roles WHERE user_id = :userId", nativeQuery = true)
    void deleteByUserId(@Param("userId") int userId);
}
