package pe.edu.upc.apirev.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.apirev.dtos.MaterialDTO;
import pe.edu.upc.apirev.dtos.QueryNativeMaterialTypeDTO;
import pe.edu.upc.apirev.entities.Material;
import pe.edu.upc.apirev.servicesinterfaces.IMaterialService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/Material")
@CrossOrigin(origins = "http://localhost:4200")
public class MaterialController {

    @Autowired
    private IMaterialService mS;

    @GetMapping("/Material")
   // @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<MaterialDTO>> listar() {
        ModelMapper m = new ModelMapper();
        List<MaterialDTO> lista = mS.list().stream()
                .map(y -> m.map(y, MaterialDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(lista);
    }

    @PostMapping("/registrar")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> registrar(@RequestBody MaterialDTO dto){
        ModelMapper m=new ModelMapper();
            Material material=m.map(dto, Material.class);
            Material cur=mS.insert(material);
        MaterialDTO responseDTO=m.map(cur,MaterialDTO.class);
            return  ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @DeleteMapping("/{id}")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        Optional<Material> material = mS.ListId(id);

        if (material.isPresent()) {
            mS.Delete(id);
            return ResponseEntity.ok("Material eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Material no encontrado");
        }
    }

    @PutMapping("/actualizar")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> actualizar(@RequestBody MaterialDTO dto) {
        Optional<Material> existente = mS.ListId(dto.getIdMaterial());
        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Material no encontrado");
        }

        Material m = existente.get();
        m.setMaterialName(dto.getMaterialName());
        m.setMaterialDescription(dto.getMaterialDescription());
        m.setMaterialType(dto.getMaterialType());

        mS.Update(m);

        return ResponseEntity.ok("Material actualizado correctamente");


    }
    @GetMapping("/buscartipo")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> searchByTypeNative(@RequestParam String type) {
        List<Object[]> rawList = mS.searchByTypeNative(type);
        
        if (rawList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron materiales para el tipo: " + type);
        }

        List<QueryNativeMaterialTypeDTO> response = new ArrayList<>();
        for (Object[] row : rawList) {
            QueryNativeMaterialTypeDTO dto = new QueryNativeMaterialTypeDTO();
            
            dto.setIdMaterial(((Number) row[0]).intValue()); 
            dto.setMaterialName((String) row[1]); 
            dto.setMaterialType((String) row[2]); 
            
            response.add(dto);
        }
        return ResponseEntity.ok(response);
    }
}