package pe.edu.upc.apirev.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.apirev.dtos.PublicationDTO;
import pe.edu.upc.apirev.entities.Publication;
import pe.edu.upc.apirev.servicesinterfaces.IPublicationService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/publicacion")
public class PublicationController {

    @Autowired
    private IPublicationService pServ;
    @GetMapping("/publicacion/listar")

    public ResponseEntity<List<PublicationDTO>> listar() {
        ModelMapper m = new ModelMapper();
        List<PublicationDTO> lista = pServ.list().stream()
                .map(y -> m.map(y, PublicationDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/publication/web")
    public ResponseEntity<PublicationDTO> registrar(@RequestBody PublicationDTO dto){
        ModelMapper m=new ModelMapper();
        Publication c=m.map(dto, Publication.class);
        Publication cur= pServ.insert(c);
        PublicationDTO responseDTO=m.map(cur,PublicationDTO.class);
        return  ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping("/publication/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        Optional<Publication> project = pServ.listId(id);

        if (project.isPresent()) {
            PublicationDTO dto = m.map(project.get(), PublicationDTO.class);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Proyecto no encontrado");
        }
    }

    @PutMapping("/publication/actualiza")
    public ResponseEntity<String> actualizar(@RequestBody PublicationDTO dto) {
        Optional<Publication> existente = pServ.listId(dto.getIdPublication());
        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Proyecto no encontrado");
        }
        if (dto.getCreationDate() == null ) {
            return ResponseEntity.badRequest()
                    .body("Las fechas no pueden ser nulas");
        }

        Publication p = existente.get();
        p.setNamePublication(dto.getNamePublication());
        p.setCreationDate(dto.getCreationDate());

        pServ.update(p);
        return ResponseEntity.ok("Proyecto actualizado correctamente");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        Optional<Publication> project = pServ.listId(id);

        if (project.isPresent()) {
            pServ.delete(id);
            return ResponseEntity.ok("Proyecto eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Proyecto no encontrado");
        }
    }






}
