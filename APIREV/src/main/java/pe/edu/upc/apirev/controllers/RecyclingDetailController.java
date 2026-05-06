package pe.edu.upc.apirev.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.apirev.dtos.RecyclingDetailDTO;
import pe.edu.upc.apirev.entities.CollectionPoint;
import pe.edu.upc.apirev.entities.RecyclingDetail;
import pe.edu.upc.apirev.servicesinterfaces.ICollectionPointService;
import pe.edu.upc.apirev.servicesinterfaces.IRecyclingDetailService;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/DetallesReciclaje")
public class RecyclingDetailController {

    @Autowired
    private IRecyclingDetailService rdS;
    private ICollectionPointService cpS;

    @GetMapping("/DetallesRecilajes")
    public ResponseEntity<List<RecyclingDetailDTO>> listar() {
        ModelMapper m = new ModelMapper();
        List<RecyclingDetailDTO> lista = rdS.list().stream()
                .map(y -> m.map(y, RecyclingDetailDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(lista);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestBody RecyclingDetailDTO dto){
        ModelMapper m=new ModelMapper();
        Optional<CollectionPoint> CollectionPoint = cpS.listId(dto.getCollectionPointId());
        if (CollectionPoint.isPresent()) {
            RecyclingDetail recyclingdetail =m.map(dto, RecyclingDetail.class);
            RecyclingDetail re=rdS.insert(recyclingdetail);
            RecyclingDetailDTO responseDTO=m.map(re,RecyclingDetailDTO.class);
            return  ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Error al registrar Detalles de reciclaje\nPunto de acopio no encontrado");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        Optional<RecyclingDetail> reciclajedetalle = rdS.ListId(id);

        if (reciclajedetalle.isPresent()) {
            rdS.Delete(id);
            return ResponseEntity.ok("Detalles de Reciclaje eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Detalles de Reciclaje no encontrado");
        }
    }

    @PutMapping("/actualizar")
    public ResponseEntity<String> actualizar(@RequestBody RecyclingDetailDTO dto) {
        Optional<RecyclingDetail> existente = rdS.ListId(dto.getRecyclingDetailsId());
        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Detalles de Reciclaje no encontrado");
        }

        RecyclingDetail r = existente.get();
        r.setDescripcionDetail(dto.getDescripcionDetail());
        r.setRegistrationDate(dto.getRegistrationDate());
        r.setTraceabilityStatus(dto.getTraceabilityStatus());

        rdS.Update(r);

        return ResponseEntity.ok("Detalles de Reciclaje actualizados correctamente");


    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        Optional<RecyclingDetail> recyclingDetail = rdS.ListId(id);

        if (recyclingDetail.isPresent()) {
            RecyclingDetailDTO dto = m.map(recyclingDetail.get(), RecyclingDetailDTO .class);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Detalles de Reciclaje no encontrado");
        }
    }

}
