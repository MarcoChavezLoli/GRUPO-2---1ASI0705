package pe.edu.upc.apirev.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.apirev.dtos.CollectionPointDTO;
import pe.edu.upc.apirev.dtos.QueryNativeCollectionPointDTO;
import pe.edu.upc.apirev.entities.CollectionPoint;
import pe.edu.upc.apirev.servicesinterfaces.ICollectionPointService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/Punto-Acopio")
public class CollectionPointController {

    @Autowired
    private ICollectionPointService cpS;

    @PostMapping("/registrar")
   @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> registrar(@RequestBody CollectionPointDTO dto){
        ModelMapper m=new ModelMapper();
            CollectionPoint collectionPoint =m.map(dto, CollectionPoint.class);
        CollectionPoint cur=cpS.insert(collectionPoint);
        CollectionPointDTO responseDTO=m.map(cur,CollectionPointDTO.class);
            return  ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping("/listar")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> Listar(){
        ModelMapper m = new ModelMapper();
        List<CollectionPointDTO> ListaPuntoAcopio = cpS.list()
                .stream().map(y->m.map(y, CollectionPointDTO.class))
                .collect(Collectors.toList());

        if (ListaPuntoAcopio.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La lista está vacía");
        }else {
            return ResponseEntity.ok(ListaPuntoAcopio);
        }
    }


    @DeleteMapping("/{id}")
   @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> eliminar(@PathVariable int id) {

        Optional<CollectionPoint> collectionPoint = cpS.listId(id);

        if (collectionPoint.isPresent()) {
            cpS.delete(id);
            return ResponseEntity.ok("Punto de acopio eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Punto de acopio no encontrado");
        }
    }



    @GetMapping("/{id}")
   // @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        Optional<CollectionPoint> collectionPoint = cpS.listId(id);

        if (collectionPoint.isPresent()) {
            CollectionPointDTO dto = m.map(collectionPoint.get(), CollectionPointDTO.class);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Punto de acopio no encontrado no encontrado");
        }
    }

    @PutMapping("/actualizar")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> actualizar(@RequestBody CollectionPointDTO dto) {
        Optional<CollectionPoint> existente = cpS.listId(dto.getIdCollectionPoint());
        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Punto de acopio no encontrado");
        }

        CollectionPoint c = existente.get();
        c.setCollectionPointLongitude(c.getCollectionPointLongitude());
        c.setCollectionPointAddress(c.getCollectionPointAddress());
        c.setCollectionPointLatitude(c.getCollectionPointLatitude());
        c.setCollectionPointName(dto.getCollectionPointName());

        cpS.update(c);

        return ResponseEntity.ok("Punto de acopio actualizado correctamente");


    }

@GetMapping("/conteo-por-direccion")
@PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> countPointsByAddress() {
        List<Object[]> rawList = cpS.countPointsByAddressNative();
        
        if (rawList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No hay puntos de acopio registrados");
        }

        List<QueryNativeCollectionPointDTO> response = new ArrayList<>();
        for (Object[] row : rawList) {
            QueryNativeCollectionPointDTO dto = new QueryNativeCollectionPointDTO();
            
            dto.setAddress((String) row[0]);
            dto.setQuantityPoints(((Number) row[1]).intValue());
            
            response.add(dto);
        }
        return ResponseEntity.ok(response);
    }
}