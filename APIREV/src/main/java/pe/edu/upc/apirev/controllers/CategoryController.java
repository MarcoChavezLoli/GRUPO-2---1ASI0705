package pe.edu.upc.apirev.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.apirev.dtos.CategoryDTO;
import pe.edu.upc.apirev.servicesinterfaces.ICategoryService;


import java.util.List;
import java.util.stream.Collectors;
@RestController
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
}
