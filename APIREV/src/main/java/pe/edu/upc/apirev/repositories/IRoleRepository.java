package pe.edu.upc.apirev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.apirev.entities.Role;

import java.util.List;

@Repository
public interface IRoleRepository extends JpaRepository<Role,Integer> {
    @Query(value = "select r.name_role,\n" +
            " count (u.id_user) as cantidad_usuarios\n" +
            " from role r\n" +
            " left join users u on r.id_role = u.id_role\n" +
            " group by r.name_role\n" +
            " order by cantidad_usuarios desc",nativeQuery = true)
    List<Object[]> quantityRoleByUser();
}
