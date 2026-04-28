package pe.edu.upc.apirev.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.apirev.dtos.RecyclingDTO;
import pe.edu.upc.apirev.entities.Recycling;
import pe.edu.upc.apirev.entities.User;
import pe.edu.upc.apirev.servicesinterfaces.IRecyclingService;
import pe.edu.upc.apirev.servicesinterfaces.IUserService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/Reciclaje")
public class RecyclingController {

    @Autowired
    private IRecyclingService rS;
    private IUserService uS;

    @GetMapping("/Reciclajes")
    public ResponseEntity<List<RecyclingDTO>> listar() {
        ModelMapper m = new ModelMapper();
        List<RecyclingDTO> lista = rS.list().stream()
                .map(y -> m.map(y, RecyclingDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(lista);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestBody RecyclingDTO dto){
        ModelMapper m=new ModelMapper();
        Optional<User> User = uS.listId(dto.getUserid());
        if (User.isPresent()) {
            Recycling recycling =m.map(dto, Recycling.class);
            Recycling re=rS.insert(recycling);
            RecyclingDTO responseDTO=m.map(re,RecyclingDTO.class);
            return  ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Error al registrar reciclaje\nusuario no encontrado");
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        Optional<Recycling> reciclaje = rS.ListId(id);

        if (reciclaje.isPresent()) {
            rS.Delete(id);
            return ResponseEntity.ok("Reciclaje eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Reciclaje no encontrado");
        }
    }


}
