package pe.edu.upc.apirev.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.apirev.dtos.ProductDTO;
import pe.edu.upc.apirev.entities.Product;
import pe.edu.upc.apirev.servicesinterfaces.IProductService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/producto")
public class ProductController {

    @Autowired
    private IProductService pPr;

    @GetMapping("/listar")
    public ResponseEntity<List<ProductDTO>> listar() {
        ModelMapper m = new ModelMapper();
        List<ProductDTO> lista = pPr.list().stream()
                .map(y -> m.map(y, ProductDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/registrar")
    public ResponseEntity<ProductDTO> registrar(@RequestBody ProductDTO dto) {
        ModelMapper m = new ModelMapper();
        Product p = m.map(dto, Product.class);
        Product cur = pPr.insert(p);
        ProductDTO responseDTO = m.map(cur, ProductDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PutMapping
    public ResponseEntity<String> actualizar(@RequestBody ProductDTO dto) {
        ModelMapper m = new ModelMapper();
        Product p = m.map(dto, Product.class);
        pPr.update(p);
        return ResponseEntity.ok("Producto actualizado correctamente");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        ModelMapper m = new ModelMapper();
        Optional<Product> product = pPr.listId(id);

        if (product.isPresent()) {
            ProductDTO dto = m.map(product.get(), ProductDTO.class);
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Producto no encontrado");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        Optional<Product> product = pPr.listId(id);

        if (product.isPresent()) {
            pPr.delete(id);
            return ResponseEntity.ok("Producto eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Producto no encontrado");
        }
    }

}
