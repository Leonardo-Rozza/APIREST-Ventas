package com.api_ventas.presentation.controller;

import com.api_ventas.service.ISaleService;
import com.api_ventas.service.dto.SaleDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("api/sales")
public class SaleController {

  private final ISaleService saleService;

  public SaleController(ISaleService saleService){
    this.saleService = saleService;
  }

  @GetMapping
  public ResponseEntity<List<SaleDTO>> getAllSales(){
    return ResponseEntity.ok(saleService.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<SaleDTO> getSaleById(@PathVariable Long id){
    return saleService.findById(id).map(ResponseEntity::ok)
            .orElseGet(()->ResponseEntity.notFound().build());
  }

  @GetMapping("/customer/{customerId}")
  public ResponseEntity<List<SaleDTO>> getSalesByCustomerId(@PathVariable Long customerId) {
    List<SaleDTO> sales = saleService.findByCustomerId(customerId);
    if (sales.isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(sales);
  }

  @GetMapping("/product/{productId}")
  public ResponseEntity<List<SaleDTO>> getSalesByProductId(@PathVariable Long productId) {
    List<SaleDTO> sales = saleService.findByProductId(productId);
    if (sales.isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(sales);
  }

  @PostMapping
  public ResponseEntity<Long> saveSale(@Valid @RequestBody SaleDTO saleDTO) throws URISyntaxException {
    Long id = saleService.save(saleDTO);
    return ResponseEntity.created(new URI("/api/sales" + id)).build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<Void> updateSale(@PathVariable Long id, @Valid @RequestBody SaleDTO saleDTO){
    saleDTO.setId(id);
    saleService.update(saleDTO);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteSale(@PathVariable Long id){
    saleService.deleteById(id);
    return ResponseEntity.noContent().build();
  }


}
