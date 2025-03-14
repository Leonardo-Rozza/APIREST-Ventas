package com.api_ventas.persistence;

import com.api_ventas.persistence.entities.ProductForSale;
import com.api_ventas.service.dto.ProductForSaleDTO;

import java.util.List;
import java.util.Optional;

public interface IProductForSaleDAO {

  List<ProductForSale> findAll();
  Optional<ProductForSale> findById(Long id);
  ProductForSale save(ProductForSale productForSale);
  void deleteById(Long id);
  void update(ProductForSale productForSale);
  List<ProductForSale> findByProductId(Long productId);
  List<ProductForSale> findByCustomerId(Long customerId);
  List<ProductForSale> findBySaleId(Long saleId);

}
