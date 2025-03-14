package com.api_ventas.persistence.impl;

import com.api_ventas.persistence.entities.ProductForSale;
import com.api_ventas.persistence.IProductForSaleDAO;
import com.api_ventas.persistence.repositories.ProductForSaleRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PorductForSaleImpl implements IProductForSaleDAO {

  private final ProductForSaleRepository productForSaleRepository;

  public PorductForSaleImpl(ProductForSaleRepository productForSaleRepository) {
    this.productForSaleRepository = productForSaleRepository;
  }

  @Override
  public List<ProductForSale> findAll() {
    return productForSaleRepository.findAll();
  }

  @Override
  public Optional<ProductForSale> findById(Long id) {
    return productForSaleRepository.findById(id);
  }

  @Override
  public ProductForSale save(ProductForSale productForSale) {
    return productForSaleRepository.save(productForSale);
  }

  @Override
  public void deleteById(Long id) {
    productForSaleRepository.deleteById(id);
  }

  @Override
  public void update(ProductForSale productForSale) {
    Optional<ProductForSale> existingProduct = productForSaleRepository.findById(productForSale.getId());

    if (existingProduct.isPresent()){
      productForSaleRepository.save(productForSale);
    } else {
      throw new IllegalArgumentException("Product for sale is not found");
    }
  }

  @Override
  public List<ProductForSale> findBySaleId(Long saleId) {
    return productForSaleRepository.findBySaleId(saleId);
  }

  @Override
  public List<ProductForSale> findByProductId(Long productId) {
    return productForSaleRepository.findByProductId(productId);
  }

  @Override
  public List<ProductForSale> findByCustomerId(Long customerId) {
    return productForSaleRepository.findByCustomerId(customerId);
  }
}
