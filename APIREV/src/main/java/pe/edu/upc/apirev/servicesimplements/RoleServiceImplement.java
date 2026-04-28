package pe.edu.upc.apirev.servicesimplements;

import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.apirev.entities.Role;
import pe.edu.upc.apirev.repositories.IRoleRepository;
import pe.edu.upc.apirev.servicesinterfaces.IRoleService;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImplement implements IRoleService {
    @Autowired
    private IRoleRepository rRepository;

    @Override
    public List<Role> list(){return rRepository.findAll();}

    @Override
    public Role insert(Role r) {
        return rRepository.save(r);
    }

    @Override
    public Optional<Role> listId(int id) {
        return rRepository.findById(id);
    }

    @Override
    public void update(Role r) {
        rRepository.save(r);

    }

    @Override
    public void delete(int id) {
        rRepository.deleteById(id);
    }

}
