package pe.edu.upc.apirev.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAuthority('TRUEQUERO')")
    public ResponseEntity<?> listar() {
        ModelMapper m = new ModelMapper();
        List<Barter> lista = bS.list();
        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existen registros de trueques en el sistema.");
        }
        List<BarterDTO> listaDTO = lista.stream()
                .map(y -> m.map(y, BarterDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(listaDTO);
    }

    @PostMapping("/trueque/registrar")
    @PreAuthorize("hasAuthority('TRUEQUERO')")
    public ResponseEntity<?> registrar(@RequestBody BarterDTO dto) {
        if (dto.getDescriptionBarter() == null || dto.getDescriptionBarter().trim().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("La descripcion de  trueque es obligatorio.");
        }

        Optional<User> user = uS.listId(dto.getIdUser());
        if (user.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuario no encontrado. Solicitud de registro denegada.");
        }
        ModelMapper m = new ModelMapper();
        Barter bt = m.map(dto, Barter.class);
        Barter bar = bS.insert(bt);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Trueque  registrado exitosamente");
    }
    @PutMapping("/trueque/actualizar")
    @PreAuthorize("hasAuthority('TRUEQUERO')")
    public ResponseEntity<String> actualizar(@RequestBody BarterDTO dto) {
        Optional<Barter> existente = bS.listId(dto.getIdBarter());
        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Trueque no encontrado");
        }
        if (dto.getDescriptionBarter() == null || dto.getDescriptionBarter().trim().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("La descripcion de  trueque es obligatorio.");
        }
        Barter b = existente.get();
        b.setDateBarter(dto.getDateBarter());
        b.setDescriptionBarter(dto.getDescriptionBarter());
        b.setDateBarter(dto.getDateBarter());

        bS.update(b);
        return ResponseEntity.status(HttpStatus.OK).body("Trueque Actualizado Correctamente");
    }

    @DeleteMapping("/eliminar/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
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
    @PreAuthorize("hasAuthority('TRUEQUERO')")
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
