package pe.edu.upc.apirev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.apirev.entities.Material;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface IMaterialRepository extends JpaRepository<Material, Integer> {
    @Query(value = "SELECT id_material, material_name, material_type " +
                   "FROM material " +
                   "WHERE material_type = :tipo", 
           nativeQuery = true)
    List<Object[]> searchMaterialsByTypeNative(@Param("tipo") String tipo);
}

