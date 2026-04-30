package pe.edu.upc.apirev.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.apirev.dtos.ItemDTO;
import pe.edu.upc.apirev.dtos.ItemGeneralDTO;
import pe.edu.upc.apirev.dtos.MaterialDTO;
import pe.edu.upc.apirev.dtos.RecyclingDTO;
import pe.edu.upc.apirev.entities.Category;
import pe.edu.upc.apirev.entities.Item;
import pe.edu.upc.apirev.entities.Material;
import pe.edu.upc.apirev.servicesinterfaces.IMaterialService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/Material")
public class MaterialController {

    @Autowired
    private IMaterialService mS;

    @GetMapping("/Material")
    public ResponseEntity<List<MaterialDTO>> listar() {
        ModelMapper m = new ModelMapper();
        List<MaterialDTO> lista = mS.list().stream()
                .map(y -> m.map(y, MaterialDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(lista);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestBody MaterialDTO dto){
        ModelMapper m=new ModelMapper();
            Material material=m.map(dto, Material.class);
            Material cur=mS.insert(material);
        MaterialDTO responseDTO=m.map(cur,MaterialDTO.class);
            return  ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @DeleteMapping("/{id}")
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

}