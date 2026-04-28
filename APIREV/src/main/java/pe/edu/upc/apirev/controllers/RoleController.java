package pe.edu.upc.apirev.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.apirev.dtos.RoleDTO;
import pe.edu.upc.apirev.dtos.RoleGeneralDTO;
import pe.edu.upc.apirev.entities.Role;
import pe.edu.upc.apirev.servicesinterfaces.IRoleService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/rol")
public class RoleController {
    @Autowired
    private IRoleService rS;

    @GetMapping("/listar/roles")
    public ResponseEntity<List<RoleDTO>> listar() {
        ModelMapper m = new ModelMapper();
        List<RoleDTO> lista = rS.list().stream()
                .map(y -> m.map(y, RoleDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(lista);
    }
    @PostMapping("/registar/roles")
    public ResponseEntity<RoleGeneralDTO> registrar(@RequestBody RoleGeneralDTO dto){
        ModelMapper m=new ModelMapper();
        Role c=m.map(dto, Role.class);
        Role cur= rS.insert(c);
        RoleGeneralDTO responseDTO=m.map(cur,RoleGeneralDTO.class);
        return  ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PutMapping("/roles/actualiza")
    public ResponseEntity<String> actualizar(@RequestBody RoleGeneralDTO dto) {
        Optional<Role> existente = rS.listId(dto.getIdRole());
        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Rol no encontrado");
        }
        Role r = existente.get();
        r.setNameRole(dto.getNameRole());
        rS.update(r);
        return ResponseEntity.status(HttpStatus.CREATED).body("Rol Actualizado Correctamente");
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        Optional<Role> role = rS.listId(id);

        if (role.isPresent()) {
            rS.delete(id);
            return ResponseEntity.ok("Rol eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Rol no encontrado");
        }
    }


    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        Optional<Role> role = rS.listId(id);

        if (role.isPresent()) {
            RoleGeneralDTO dto = m.map(role.get(), RoleGeneralDTO.class);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Rol no encontrado");
        }
    }
}
