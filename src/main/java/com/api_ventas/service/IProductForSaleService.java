package com.api_ventas.service;

import com.api_ventas.persistence.entities.ProductForSale;
import com.api_ventas.service.dto.ProductForSaleDTO;

import java.util.List;
import java.util.Optional;

public interface IProductForSaleService {

  List<ProductForSaleDTO> findAll();
  Optional<ProductForSaleDTO> findById(Long id);
  Long save(ProductForSaleDTO productForSaleDTO);
  void deleteById(Long id);
  void update(ProductForSaleDTO productForSaleDTO);
  List<ProductForSaleDTO> findByProductId(Long productId);
  List<ProductForSaleDTO> findByCustomerId(Long customerId);
  List<ProductForSaleDTO> findBySaleId(Long saleId);
}
