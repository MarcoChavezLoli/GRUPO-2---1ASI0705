package pe.edu.upc.apirev.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.apirev.dtos.QueryNativeRoleDTO;
import pe.edu.upc.apirev.dtos.RoleDTO;
import pe.edu.upc.apirev.dtos.RoleGeneralDTO;
import pe.edu.upc.apirev.entities.Role;
import pe.edu.upc.apirev.entities.User;
import pe.edu.upc.apirev.servicesinterfaces.IRoleService;
import pe.edu.upc.apirev.servicesinterfaces.IUserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/rol")
public class RoleController {
    @Autowired
    private IRoleService rS;
    @Autowired
    private IUserService uS;

    @GetMapping("/listar/roles")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> listar() {
        ModelMapper m = new ModelMapper();
        List<Role> rolesExistentes = rS.list();

        if (rolesExistentes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existen roles registrados en el sistema.");
        }
        List<RoleDTO> lista = rolesExistentes.stream()
                .map(y -> m.map(y, RoleDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(lista);
    }

    @PostMapping("/registrar/roles")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> registrar(@RequestBody RoleGeneralDTO dto) {

        Optional<User> userOpt = uS.listId(dto.getIdUser());

        if (userOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Usuario no encontrado.");
        }
        if (dto.getNameRole() == null || dto.getNameRole().trim().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("El nombre del rol no puede estar vacío");
        }

        Role role = new Role();
        role.setNameRole(dto.getNameRole());
        role.setUser(userOpt.get());
        rS.insert(role);
        return ResponseEntity.status(HttpStatus.CREATED).body("Rol registrado correctamente.");
    }

    @PutMapping("/roles/actualiza")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> actualizar(@RequestBody RoleGeneralDTO dto) {
        Optional<Role> existente = rS.listId(dto.getIdRole());
        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Rol no encontrado");
        }
        if (dto.getNameRole() == null || dto.getNameRole().trim().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("El nombre del rol no puede estar vacío");
        }
        Role r = existente.get();
        r.setNameRole(dto.getNameRole());
        rS.update(r);
        return ResponseEntity.status(HttpStatus.OK).body("Rol Actualizado Correctamente");
    }

    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
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
    @PreAuthorize("hasAuthority('ADMIN')")
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

    @GetMapping("/cantidad-usuarios-rol")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?>obtenerCantidadUsuarioRol(){
        List<Object[]> listaCantidad=rS.quantityRoleByUser();
        if(listaCantidad.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No hay roles asignados");
        }
        List<QueryNativeRoleDTO> respuesta=new ArrayList<>();
        for(Object[] fila:listaCantidad){
            QueryNativeRoleDTO dto=new QueryNativeRoleDTO();
            dto.setNameRole((String)fila[0]);
            dto.setQuantityUser(((Number)fila[1]).intValue());

            respuesta.add(dto);
        }
        return  ResponseEntity.ok(respuesta);
    }
}
