package pe.edu.upc.apirev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.apirev.dtos.MaterialDTO;
import pe.edu.upc.apirev.entities.Material;
import pe.edu.upc.apirev.servicesinterfaces.IMaterialService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/materiales")
public class MaterialController {

    @Autowired
    private IMaterialService mS;

    @PostMapping
    public void insert(@RequestBody MaterialDTO dto) {
        Material m = new Material();
        m.setMaterialName(dto.getMaterialName());
        m.setMaterialDescription(dto.getMaterialDescription());
        m.setMaterialType(dto.getMaterialType());
        mS.insert(m);
    }

    @GetMapping
    public List<MaterialDTO> list() {
        return mS.list().stream().map(x -> {
            MaterialDTO dto = new MaterialDTO();
            dto.setIdMaterial(x.getIdMaterial());
            dto.setMaterialName(x.getMaterialName());
            dto.setMaterialDescription(x.getMaterialDescription());
            dto.setMaterialType(x.getMaterialType());
            return dto;
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        mS.delete(id);
    }

    @GetMapping("/{id}")
    public MaterialDTO listId(@PathVariable("id") int id) {
        Material m = mS.listId(id);
        MaterialDTO dto = new MaterialDTO();
        dto.setIdMaterial(m.getIdMaterial());
        dto.setMaterialName(m.getMaterialName());
        dto.setMaterialDescription(m.getMaterialDescription());
        dto.setMaterialType(m.getMaterialType());
        return dto;
    }

    @PutMapping
    public void update(@RequestBody MaterialDTO dto) {
        Material m = new Material();
        m.setIdMaterial(dto.getIdMaterial());
        m.setMaterialName(dto.getMaterialName());
        m.setMaterialDescription(dto.getMaterialDescription());
        m.setMaterialType(dto.getMaterialType());
        mS.update(m);
    }
}