package pe.edu.upc.apirevive.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.apirevive.entities.PublicationSave;
import pe.edu.upc.apirevive.entities.Role;

public interface IPublicationSaveRepository extends JpaRepository<PublicationSave,Integer> {
}
