package pe.edu.upc.apirev.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.apirev.dtos.RoleDTO;
import pe.edu.upc.apirev.dtos.RoleGeneralDTO;
import pe.edu.upc.apirev.dtos.UserDTO;
import pe.edu.upc.apirev.entities.Role;
import pe.edu.upc.apirev.entities.User;
import pe.edu.upc.apirev.servicesinterfaces.IRoleService;
import pe.edu.upc.apirev.servicesinterfaces.IUserService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/usuario")
public class UserController {
    @Autowired
    private IUserService uS;
    @Autowired
    private IRoleService rS;
    @GetMapping("/usuarios/listar")
    public ResponseEntity<List<UserDTO>> listar() {
        ModelMapper m = new ModelMapper();
        List<UserDTO> lista = uS.list().stream()
                .map(y -> m.map(y, UserDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(lista);
    }

    @PostMapping("/usuarios/registrar")
    public ResponseEntity<?> registrar(@RequestBody UserDTO dto){
        ModelMapper m=new ModelMapper();
        Optional<Role> role = rS.listId(dto.getIdRole());
        if (role.isPresent()) {
            User us=m.map(dto, User.class);
            User use= uS.insert(us);
            UserDTO responseDTO=m.map(use,UserDTO.class);
            return  ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Rol no encontrado\nSolicitud de registro denegada");
        }
    }
    @PutMapping("/usuarios/actualizar")
    public ResponseEntity<String> actualizar(@RequestBody UserDTO dto) {
        Optional<User> existente = uS.listId(dto.getIdUser());
        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuario no encontrado");
        }
        User u = existente.get();
        u.setUserEmail(dto.getUserEmail());
        u.setUserName(dto.getUserName());
        u.setUserIdentityDocument(dto.getUserIdentityDocument());
        u.setUserPassword(dto.getUserPassword());
        u.setUserRegistrationDate(dto.getUserRegistrationDate());
        u.setUserLastName(dto.getUserLastName());

        uS.update(u);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario Actualizado Correctamente");
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        Optional<User> user = uS.listId(id);

        if (user.isPresent()) {
            uS.delete(id);
            return ResponseEntity.ok("Usuario eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuario no encontrado");
        }
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        Optional<User> user = uS.listId(id);

        if (user.isPresent()) {
            UserDTO dto = m.map(user.get(), UserDTO.class);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuario no encontrado");
        }
    }
}
