package com.api_ventas.persistence.impl;

import com.api_ventas.persistence.entities.Sale;
import com.api_ventas.persistence.ISaleDAO;
import com.api_ventas.persistence.repositories.SaleRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SaleImpl implements ISaleDAO {

  private final SaleRepository saleRepository;

  public SaleImpl(SaleRepository saleRepository){
    this.saleRepository = saleRepository;
  }

  @Override
  public List<Sale> findAll() {
    return saleRepository.findAll();
  }

  @Override
  public Optional<Sale> findById(Long id) {
    return saleRepository.findById(id);
  }

  @Override
  public Sale save(Sale sale) {
    saleRepository.save(sale);
  }

  @Override
  public void update(Sale sale) {
    Optional<Sale> existingSale = saleRepository.findById(sale.getId());

    if (existingSale.isPresent()){
      saleRepository.save(sale);
    } else {
      throw new IllegalArgumentException("Sale is not found");
    }
  }

  @Override
  public void deleteById(Long id) {
    saleRepository.deleteById(id);
  }

  @Override
  public List<Sale> findByCustomerId(Long customerId) {
    return saleRepository.findByCustomerId(customerId);
  }

  @Override
  public List<Sale> findByProductId(Long productId) {
    return saleRepository.findByProductId(productId);
  }
}
