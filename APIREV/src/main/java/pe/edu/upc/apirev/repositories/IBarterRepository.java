package pe.edu.upc.apirev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.apirev.entities.Barter;

import java.util.List;

@Repository
public interface IBarterRepository extends JpaRepository<Barter,Integer> {
    @Query(value = """
            select\s
            concat (u.user_name, ' ' , u.user_last_name) as Nombre_Completo,
            to_char(b.date_barter,'Mon') as Fecha,
            count(b.*) as Cantidad
            from barter b\s
            inner join users u on b.id_user = u.id_user
            group by u.user_name , u.user_last_name, b.date_barter
            """, nativeQuery = true)
    public List<Object[]> findAllWithUsers();
}
