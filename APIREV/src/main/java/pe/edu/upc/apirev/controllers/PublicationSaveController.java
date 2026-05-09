package pe.edu.upc.apirev.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pe.edu.upc.apirev.dtos.PublicationSaveDTO;

import pe.edu.upc.apirev.entities.PublicationSave;
import pe.edu.upc.apirev.servicesinterfaces.IPublicationSaveService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/publicationsave")
public class PublicationSaveController {
    @Autowired
    private IPublicationSaveService psServ;

    @GetMapping("/publicationsave/list")
    public ResponseEntity<List<PublicationSaveDTO>> listar() {
        ModelMapper m = new ModelMapper();
        List<PublicationSaveDTO> listaPSave = psServ.list().stream()
                .map(y -> m.map(y, PublicationSaveDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(listaPSave);

    }

    @PostMapping("/publicationsave/web")
    public ResponseEntity<PublicationSaveDTO> registrar(@RequestBody PublicationSaveDTO dto) {
        ModelMapper m = new ModelMapper();
        PublicationSave c = m.map(dto, PublicationSave.class);
        PublicationSave cur = psServ.insert(c);
        PublicationSaveDTO responseDTO = m.map(cur, PublicationSaveDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping("/publication/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        Optional<PublicationSave> project = psServ.listId(id);

        if (project.isPresent()) {
            PublicationSaveDTO dto = m.map(project.get(), PublicationSaveDTO.class);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Publicacion no encontrado");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        Optional<PublicationSave> project = psServ.listId(id);

        if (project.isPresent()) {
            psServ.delete(id);
            return ResponseEntity.ok("Proyecto eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Proyecto no encontrado");
        }
    }

}
