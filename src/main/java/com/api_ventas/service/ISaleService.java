package com.api_ventas.service;

import com.api_ventas.persistence.entities.Sale;
import com.api_ventas.service.dto.SaleDTO;

import java.util.List;
import java.util.Optional;

public interface ISaleService {

  List<SaleDTO> findAll();
  Optional<SaleDTO> findById(Long id);
  Long save(SaleDTO saleDTO);
  void update(SaleDTO saleDTO);
  void deleteById(Long id);
  List<SaleDTO> findByCustomerId(Long customerId);
  List<SaleDTO> findByProductId(Long productId);
}
