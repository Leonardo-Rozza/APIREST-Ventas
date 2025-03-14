package com.api_ventas.presentation.controller;

import com.api_ventas.service.IProductService;
import com.api_ventas.service.dto.ProductDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

  private final IProductService productService;

  public ProductController(IProductService productService){
    this.productService = productService;
  }

  @GetMapping
  public ResponseEntity<List<ProductDTO>> getAllproducts(){
    return ResponseEntity.ok(productService.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id){
    return productService.findById(id).map(ResponseEntity::ok)
            .orElseGet(() ->ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<Void> saveProduct(@Valid @RequestBody ProductDTO productDTO) throws URISyntaxException {
    Long productId = productService.save(productDTO);
    return ResponseEntity.created(new URI("/api/products/" + productId)).build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<Void> updateProduct(@PathVariable Long id, @Valid @RequestBody ProductDTO productDTO){
    productDTO.setId(id);
    productService.update(productDTO);
    return ResponseEntity.noContent().build();
  }

  @PatchMapping("/{id}/update-stock")
  public ResponseEntity<Void> updateStockAfterSale(
          @PathVariable Long id,
          @RequestParam int quantitySold) {
    productService.updateStockAfterSale(id, quantitySold);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
    productService.deleteById(id);
    return ResponseEntity.noContent().build();
  }

}
