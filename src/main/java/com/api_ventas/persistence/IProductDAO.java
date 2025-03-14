package com.api_ventas.persistence;


import com.api_ventas.persistence.entities.Product;

import java.util.List;
import java.util.Optional;

public interface IProductDAO {

  List<Product> findAll();
  Optional<Product> findById(Long id);
  Product save(Product product);
  void update(Product product);
  void deleteById(Long id);
  void updateStockAfterSale(Long productId, int quantitySold);
}
