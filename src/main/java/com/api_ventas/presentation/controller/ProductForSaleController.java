package com.api_ventas.presentation.controller;

import com.api_ventas.service.IProductForSaleService;
import com.api_ventas.service.dto.ProductForSaleDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/products-for-sales")
public class ProductForSaleController {

  private final IProductForSaleService productForSaleService;

  public ProductForSaleController(IProductForSaleService productForSaleService){
    this.productForSaleService = productForSaleService;
  }

  @GetMapping
  public ResponseEntity<List<ProductForSaleDTO>> getAllProductForSale(){
    return ResponseEntity.ok(productForSaleService.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<ProductForSaleDTO> getProductForSaleById(@PathVariable @Valid Long id){
    return productForSaleService.findById(id).map(ResponseEntity::ok)
            .orElseGet(()->ResponseEntity.notFound().build());
  }

  @GetMapping("/by-product/{productId}")
  public ResponseEntity<List<ProductForSaleDTO>> getByProductId(@PathVariable Long productId) {
    List<ProductForSaleDTO> products = productForSaleService.findByProductId(productId);
    return ResponseEntity.ok(products);
  }

  @GetMapping("/by-customer/{customerId}")
  public ResponseEntity<List<ProductForSaleDTO>> getByCustomerId(@PathVariable Long customerId) {
    List<ProductForSaleDTO> products = productForSaleService.findByCustomerId(customerId);
    return ResponseEntity.ok(products);
  }

  @GetMapping("/by-sale/{saleId}")
  public ResponseEntity<List<ProductForSaleDTO>> getBySaleId(@PathVariable Long saleId) {
    List<ProductForSaleDTO> products = productForSaleService.findBySaleId(saleId);
    return ResponseEntity.ok(products);
  }

  @PostMapping
  public ResponseEntity<Void> saveProductForSale(@RequestBody @Valid ProductForSaleDTO product) throws URISyntaxException {
    Long productForSaleId = productForSaleService.save(product);
    return ResponseEntity.created(new URI("/api/products-for-sales" + productForSaleId)).build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<Void> updateProductForSale(@PathVariable Long id, @RequestBody @Valid ProductForSaleDTO product){
    product.setId(id);
    productForSaleService.update(product);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteProductForSale(@PathVariable Long id){
    productForSaleService.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
