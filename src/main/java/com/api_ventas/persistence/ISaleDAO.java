package com.api_ventas.persistence;

import com.api_ventas.persistence.entities.Sale;

import java.util.List;
import java.util.Optional;

public interface ISaleDAO {

  List<Sale> findAll();
  Optional<Sale> findById(Long id);
  Sale save(Sale sale);
  void update(Sale sale);
  void deleteById(Long id);
  List<Sale> findByCustomerId(Long customerId);
  List<Sale> findByProductId(Long productId);
}
