package pe.edu.upc.apirev.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.apirev.dtos.BarterDTO;
import pe.edu.upc.apirev.entities.Barter;
import pe.edu.upc.apirev.entities.User;
import pe.edu.upc.apirev.servicesinterfaces.IBarterService;
import pe.edu.upc.apirev.servicesinterfaces.IUserService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping ("/api/trueque")
public class BarterController {

     @Autowired
     private IUserService uS;
     @Autowired
     private IBarterService bS;

    @GetMapping("/trueque/listar")
    public ResponseEntity<List<BarterDTO>> listar() {
        ModelMapper m = new ModelMapper();
        List<BarterDTO> lista = bS.list().stream()
                .map(y -> m.map(y, BarterDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(lista);
    }

    @PostMapping("/trueque/registrar")
    public ResponseEntity<?> registrar(@RequestBody BarterDTO dto){
        ModelMapper m=new ModelMapper();
        Optional<User> user = uS.listId(dto.getIdUser());
        if (user.isPresent()) {
            Barter bt=m.map(dto, Barter.class);
            Barter bar= bS.insert(bt);
            BarterDTO responseDTO=m.map(bar,BarterDTO.class);
            return  ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuario no encontrado\nSolicitud de registro denegada");
        }
    }
    @PutMapping("/trueque/actualizar")
    public ResponseEntity<String> actualizar(@RequestBody BarterDTO dto) {
        Optional<Barter> existente = bS.listId(dto.getIdBarter());
        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Trueque no encontrado");
        }
        Barter b = existente.get();
        b.setDateBarter(dto.getDateBarter());
        b.setDescriptionBarter(dto.getDescriptionBarter());
        b.setDateBarter(dto.getDateBarter());

        bS.update(b);
        return ResponseEntity.status(HttpStatus.CREATED).body("Trueque Actualizado Correctamente");
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        Optional<Barter> barter = bS.listId(id);

        if (barter.isPresent()) {
            bS.delete(id);
            return ResponseEntity.ok("Trueque eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Trueque no encontrado");
        }
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        Optional<Barter> barter  = bS.listId(id);

        if (barter.isPresent()) {
            BarterDTO dto = m.map(barter.get(), BarterDTO.class);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("trueque no encontrado");
        }
    }


}
