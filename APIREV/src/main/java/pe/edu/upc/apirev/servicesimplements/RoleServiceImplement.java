package pe.edu.upc.apirev.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.apirev.entities.Role;
import pe.edu.upc.apirev.repositories.IRoleRepository;
import pe.edu.upc.apirev.servicesinterfaces.IRoleService;

import java.util.List;

@Service
public class RoleServiceImplement implements IRoleService {
    @Autowired
    private IRoleRepository rRepository;

    @Override
    public List<Role> list(){return rRepository.findAll();}
}
