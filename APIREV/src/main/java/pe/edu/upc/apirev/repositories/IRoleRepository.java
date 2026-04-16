package pe.edu.upc.apirev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.apirev.entities.Role;

@Repository
public interface IRoleRepository extends JpaRepository<Role,Integer> {
}
