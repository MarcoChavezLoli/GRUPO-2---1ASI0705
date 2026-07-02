package pe.edu.upc.apirev.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.apirev.dtos.PublicationDTO;
import pe.edu.upc.apirev.dtos.QueryPublicationDTO;
import pe.edu.upc.apirev.entities.Product;
import pe.edu.upc.apirev.entities.Publication;
import pe.edu.upc.apirev.entities.User;
import pe.edu.upc.apirev.servicesinterfaces.IProductService;
import pe.edu.upc.apirev.servicesinterfaces.IPublicationService;
import pe.edu.upc.apirev.servicesinterfaces.IUserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/publicacion")
//@PreAuthorize("hasAnyAuthority('ADMIN','RECOLECTOR')")
public class PublicationController {

    @Autowired
    private IPublicationService pServ;

    @Autowired
    private IUserService uS;

    @Autowired
    private IProductService pPr;

    @GetMapping("/publicacion/listar")

    public ResponseEntity<List<PublicationDTO>> listar() {
        ModelMapper m = new ModelMapper();
        List<PublicationDTO> lista = pServ.list().stream()
                .map(y -> m.map(y, PublicationDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/publication/registrar")
    public ResponseEntity<?> registrar(@RequestBody PublicationDTO dto) {
        ModelMapper m = new ModelMapper();

        Optional<User> userOpt = uS.listId(dto.getIdUser());
        if (userOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Error: El usuario con ID " + dto.getIdUser() + " no existe.");
        }

        Optional<Product> prodOpt = pPr.listId(dto.getIdProduct());
        if (prodOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Error: El producto con ID " + dto.getIdProduct() + " no existe.");
        }
        Publication publication = m.map(dto, Publication.class);
        publication.setUser(userOpt.get());
        publication.setProduct(prodOpt.get());
        Publication cur = pServ.insert(publication);
        PublicationDTO responseDTO = m.map(cur, PublicationDTO.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
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

    @PutMapping("/publication/actualizar")
    public ResponseEntity<String> actualizar(@RequestBody PublicationDTO dto) {
        Optional<Publication> existente = pServ.listId(dto.getIdPublication());
        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Publicacion no encontrado");
        }
        if (dto.getCreationDate() == null) {
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

    @GetMapping("/cantidad-publicaciones-usuario")
    public ResponseEntity<?> obtenerCantidadPublicacionesUsuario() {

        List<Object[]> listaCantidad = pServ.quantityPublicationsByUser();

        if (listaCantidad.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No hay Publicaciones");
        }

        List<QueryPublicationDTO> respuesta = new ArrayList<>();
        for (Object[] fila : listaCantidad) {
            QueryPublicationDTO dto = new QueryPublicationDTO();

            dto.setIdUser(((Number) fila[0]).intValue());
            dto.setUserName((String) fila[1]);
            dto.setTotalPublicaciones(((Number) fila[2]).longValue());

            respuesta.add(dto);
        }
        return ResponseEntity.ok(respuesta);
    }






}