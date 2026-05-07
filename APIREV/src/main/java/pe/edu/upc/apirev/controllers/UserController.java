package pe.edu.upc.apirev.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.apirev.dtos.QueryNativeUserDTO;
import pe.edu.upc.apirev.dtos.UserDTO;
import pe.edu.upc.apirev.dtos.UserGeneralDTO;
import pe.edu.upc.apirev.entities.User;
import pe.edu.upc.apirev.servicesinterfaces.IUserService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/usuario")
public class UserController {
    @Autowired
    private IUserService uS;

    @GetMapping("/usuarios/listar")
    public ResponseEntity<List<UserGeneralDTO>> listar() {
        List<UserGeneralDTO> lista = uS.list().stream()
                .map(user -> {
                    UserGeneralDTO dto = new UserGeneralDTO();
                    dto.setIdUser(user.getIdUser());
                    dto.setUserName(user.getUserName());
                    dto.setUserLastName(user.getUserLastName());
                    dto.setUserIdentityDocument(user.getUserIdentityDocument());
                    dto.setUserEmail(user.getUserEmail());
                    dto.setUserRegistrationDate(user.getUserRegistrationDate());
                    return dto;
                })
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }
    @PostMapping("/registrar/usuarios")
    public ResponseEntity<?> registrar(@RequestBody UserDTO dto){

        // Validaciones
        if (dto.getUserName() == null || dto.getUserName().trim().isEmpty() ||
                dto.getUserLastName() == null || dto.getUserLastName().trim().isEmpty() ||
                dto.getUserIdentityDocument() == null || dto.getUserIdentityDocument().trim().isEmpty() ||
                dto.getUserEmail() == null || dto.getUserEmail().trim().isEmpty() ||
                dto.getUserPassword() == null || dto.getUserPassword().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Campos obligatorios vacíos.");
        }

        if (dto.getUserIdentityDocument().trim().length() != 8) {
            return ResponseEntity.badRequest().body("El DNI debe tener 8 caracteres.");
        }


        User user = new User();
        user.setUserName(dto.getUserName());
        user.setUserLastName(dto.getUserLastName());
        user.setUserIdentityDocument(dto.getUserIdentityDocument());
        user.setUserEmail(dto.getUserEmail());
        user.setUserPassword(new BCryptPasswordEncoder().encode(dto.getUserPassword())); // hash
        user.setUserRegistrationDate(LocalDate.now());
        user.setEnabled(true);

        User saved = uS.insert(user);

        UserGeneralDTO response = new UserGeneralDTO();
        response.setIdUser(saved.getIdUser());
        response.setUserName(saved.getUserName());
        response.setUserLastName(saved.getUserLastName());
        response.setUserIdentityDocument(saved.getUserIdentityDocument());
        response.setUserEmail(saved.getUserEmail());
        response.setUserRegistrationDate(saved.getUserRegistrationDate());

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
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

    @GetMapping("/lista-usuarios-trueque")
    public ResponseEntity<?>obtenerListaUsuarioSinTrueque(){
        List<Object[]> lista=uS.usersWithoutBarter();
        if(lista.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No hay lista de usuarios sin trueques");
        }
        List<QueryNativeUserDTO> respuesta=new ArrayList<>();
        for(Object[] fila:lista){
            QueryNativeUserDTO dto=new QueryNativeUserDTO();
            dto.setIdUser(((Number) fila[0]).intValue());
            dto.setUserName((String) fila[1]);
            dto.setUserEmail((String) fila[2]);
            dto.setUserRegistrationDate((LocalDate) fila[3]);

            respuesta.add(dto);
        }
        return  ResponseEntity.ok(respuesta);
    }
}
