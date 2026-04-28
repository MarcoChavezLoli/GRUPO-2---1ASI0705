package pe.edu.upc.apirev.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.apirev.dtos.CategoryDTO;
import pe.edu.upc.apirev.dtos.ItemGeneralDTO;
import pe.edu.upc.apirev.entities.Category;
import pe.edu.upc.apirev.entities.Item;
import pe.edu.upc.apirev.servicesinterfaces.ICategoryService;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/Categoria")
public class CategoryController {
    @Autowired
    private ICategoryService cS;


    @GetMapping("/categorias")
    public ResponseEntity<List<CategoryDTO>> listar() {
        ModelMapper m = new ModelMapper();
        List<CategoryDTO> lista = cS.list().stream()
                .map(y -> m.map(y, CategoryDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(lista);
    }

    @PostMapping("/registrar")
    public ResponseEntity<CategoryDTO> registrar(@RequestBody CategoryDTO dto){
        ModelMapper m=new ModelMapper();
        Category r=m.map(dto, Category.class);
        Category cur= cS.insert(r);
        CategoryDTO responseDTO=m.map(cur,CategoryDTO.class);
        return  ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        Optional<Category> category = cS.ListId(id);

        if (category.isPresent()) {
            cS.Delete(id);
            return ResponseEntity.ok("Categoría eliminada correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Categoría no encontrada");
        }
    }

    @PutMapping("/actualizar")
    public ResponseEntity<String> actualizar(@RequestBody CategoryDTO dto) {
        Optional<Category> existente = cS.ListId(dto.getIdCategory());
        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Categoría no encontrada");
        }

        Category c = existente.get();
        c.setDescriptionCategory(dto.getDescriptionCategory());
        c.setNameCategory(dto.getNameCategory());
        c.setStateCategory(dto.isStatusCategory());

        cS.Update(c);

        return ResponseEntity.ok("Categoría actualizada correctamente");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        Optional<Category> category = cS.ListId(id);

        if (category.isPresent()) {
            CategoryDTO dto = m.map(category.get(), CategoryDTO.class);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Categoría no encontrada");
        }
    }

}
