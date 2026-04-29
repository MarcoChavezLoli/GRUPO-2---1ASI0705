package pe.edu.upc.apirev.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.apirev.dtos.ProductDTO;
import pe.edu.upc.apirev.servicesinterfaces.IProductService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/producto")
public class ProductController {
    @Autowired
    private IProductService pPr;
    @GetMapping("/producto/listar")
    public ResponseEntity<List<ProductDTO>> listar() {
        ModelMapper m = new ModelMapper();
        List<ProductDTO> lista = pPr.list().stream()
                .map(y -> m.map(y, ProductDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }
}
