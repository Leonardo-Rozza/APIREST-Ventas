package com.api_ventas.service;

import com.api_ventas.persistence.entities.Product;
import com.api_ventas.service.dto.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface IProductService {


  List<ProductDTO> findAll();
  Optional<ProductDTO> findById(Long id);
  Long save(ProductDTO productDTO);
  void update(ProductDTO productDTO);
  void deleteById(Long id);
  void updateStockAfterSale(Long productId, int quantitySold);
}
