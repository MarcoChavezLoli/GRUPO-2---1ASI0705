package pe.edu.upc.apirev.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.apirev.dtos.*;
import pe.edu.upc.apirev.entities.Recycling;
import pe.edu.upc.apirev.entities.User;
import pe.edu.upc.apirev.servicesinterfaces.IRecyclingService;
import pe.edu.upc.apirev.servicesinterfaces.IUserService;

import java.util.ArrayList;
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
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<RecyclingDTO>> listar() {
        ModelMapper m = new ModelMapper();
        List<RecyclingDTO> lista = rS.list().stream()
                .map(y -> m.map(y, RecyclingDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(lista);
    }

    @PostMapping("/registrar")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> registrar(@RequestBody RecyclingDTO dto) {
        ModelMapper m = new ModelMapper();
        Optional<User> User = uS.listId(dto.getUserid());
        if (User.isPresent()) {
            Recycling recycling = m.map(dto, Recycling.class);
            Recycling re = rS.insert(recycling);
            RecyclingDTO responseDTO = m.map(re, RecyclingDTO.class);
            return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Error al registrar reciclaje\nusuario no encontrado");
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        Optional<Recycling> reciclaje = rS.ListId(id);

        if (reciclaje.isPresent()) {
            rS.delete(id);
            return ResponseEntity.ok("Reciclaje eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Reciclaje no encontrado");
        }
    }

    @PutMapping("/actualizar")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> actualizar(@RequestBody RecyclingDTO dto) {
        Optional<Recycling> existente = rS.ListId(dto.getRecyclingId());
        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Reciclaje no encontrado");
        }

        Recycling r = existente.get();
        r.setRecyclingName(dto.getRecyclingName());

        rS.Update(r);

        return ResponseEntity.ok("Reciclaje actualizado correctamente");


    }

    @GetMapping("/buscar/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        Optional<Recycling> recycling = rS.ListId(id);

        if (recycling.isPresent()) {
            RecyclingDTO dto = m.map(recycling.get(), RecyclingDTO.class);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Reciclaje no encontrado");
        }
    }


    @GetMapping("/cantidad-Reciclajes-Categoria")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?>obtenerCantidadReciclajesUsuario(){
        List<Object[]> listaCantidad=rS.quantityRecyclingNative();
        if(listaCantidad.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No hay Reciclajes");
        }
        List<QueryNative2DTO> respuesta=new ArrayList<>();
        for(Object[] fila:listaCantidad){
            QueryNative2DTO dto=new QueryNative2DTO();

            dto.setIdUser(((Number)fila[0]).intValue());
            dto.setNameUser((String) fila[1]);
            dto.setQuantityRecycling(((Number)fila[2]).intValue());
            respuesta.add(dto);
        }
        return  ResponseEntity.ok(respuesta);
    }

}
