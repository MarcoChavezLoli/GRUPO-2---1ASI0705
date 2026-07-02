package pe.edu.upc.apirev.controllers;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.apirev.dtos.ProductDTO;
import pe.edu.upc.apirev.dtos.QueryProductCategoryDTO;
import pe.edu.upc.apirev.entities.Barter;
import pe.edu.upc.apirev.entities.Category;
import pe.edu.upc.apirev.entities.Product;
import pe.edu.upc.apirev.servicesinterfaces.IBarterService;
import pe.edu.upc.apirev.servicesinterfaces.ICategoryService;
import pe.edu.upc.apirev.servicesinterfaces.IProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/producto")
@PreAuthorize("hasAnyAuthority('ADMIN','RECOLECTOR','TRUEQUERO')")
public class ProductController {

    @Autowired
    private IProductService pPr;
    @Autowired
    private IBarterService bS;
    @Autowired
    private ICategoryService cS;

    @GetMapping("/listar")
    public ResponseEntity<List<ProductDTO>> listar() {
        ModelMapper m = new ModelMapper();
        List<ProductDTO> lista = pPr.list().stream()
                .map(y -> m.map(y, ProductDTO.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar(@RequestBody ProductDTO dto) {

        if (dto.getNameProduct() == null || dto.getNameProduct().trim().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("El nombre del producto es obligatorio.");
        }

        if (dto.getNameProduct().length() < 3) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("El nombre del producto debe tener al menos 3 caracteres.");
        }

        if (dto.getDescriptionProduct() == null || dto.getDescriptionProduct().trim().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("La descripción del producto es obligatoria.");
        }

        if (dto.getConservationStatus() == null || dto.getConservationStatus().trim().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("El estado de conservación es obligatorio.");
        }

        if (dto.getIdBarter() <= 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Debe seleccionar un trueque válido.");
        }

        if (dto.getIdCategory() <= 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Debe seleccionar una categoría válida.");
        }

        Optional<Barter> barter = bS.listId(dto.getIdBarter());
        if (barter.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El trueque no existe.");
        }

        // Verificar que exista la categoría
        Optional<Category> category = cS.ListId(dto.getIdCategory());
        if (category.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("La categoría no existe.");
        }


        Product product = toEntityProduct(dto);
        product.setBarter(barter.get());
        product.setCategory(category.get());

        ProductDTO productDTOSave =  toDtoProduct(pPr.insert(product));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productDTOSave);
    }

    private Product toEntityProduct(ProductDTO productDTO){
        Product product = new Product();
        product.setNameProduct(productDTO.getNameProduct());
        product.setDescriptionProduct(productDTO.getDescriptionProduct());
        product.setConservationStatus(productDTO.getConservationStatus());
        return product;
    }
    private ProductDTO toDtoProduct(Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setIddProduct(product.getIdProduct());
        productDTO.setDescriptionProduct(product.getDescriptionProduct());
        productDTO.setNameProduct(product.getNameProduct());
        productDTO.setConservationStatus(product.getConservationStatus());
        productDTO.setIdBarter(product.getBarter().getIdBarter());
        productDTO.setIdCategory(product.getCategory().getIdCategory());
        return productDTO;
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

    @GetMapping("/cantidad-productos-categoria")
    public ResponseEntity<?> cantidadProductosPorCategoria() {

        List<Object[]> lista = pPr.countProductsByCategory();

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existen categorías registradas.");
        }

        List<QueryProductCategoryDTO> respuesta = new ArrayList<>();

        for (Object[] fila : lista) {

            QueryProductCategoryDTO dto = new QueryProductCategoryDTO();

            dto.setIdCategory(((Number) fila[0]).intValue());
            dto.setNameCategory((String) fila[1]);
            dto.setTotalProductos(((Number) fila[2]).longValue());

            respuesta.add(dto);
        }

        return ResponseEntity.ok(respuesta);
    }

}