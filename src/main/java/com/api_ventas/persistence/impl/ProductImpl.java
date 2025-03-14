package com.api_ventas.persistence.impl;

import com.api_ventas.persistence.entities.Product;
import com.api_ventas.persistence.IProductDAO;
import com.api_ventas.persistence.repositories.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class ProductImpl implements IProductDAO {

  private final ProductRepository productRepository;

  public ProductImpl (ProductRepository productRepository){
    this.productRepository = productRepository;
  }

  @Override
  public List<Product> findAll() {
    return productRepository.findAll();
  }

  @Override
  public Optional<Product> findById(Long id) {
    return productRepository.findById(id);
  }

  @Override
  public Product save(Product product) {
    return productRepository.save(product);
  }

  @Override
  public void update(Product product) {
    Optional<Product> existingProduct = productRepository.findById(product.getId());

    if (existingProduct.isPresent()){
      productRepository.save(product);
    } else {
      throw new IllegalArgumentException("Product not found");
    }

  }

  @Override
  public void deleteById(Long id) {
    productRepository.deleteById(id);
  }

  @Override
  public void updateStockAfterSale(Long productId, int quantitySold) {

    int rowsAffected = productRepository.updateStockAfterSale(productId, quantitySold);

    if (rowsAffected == 0) {
      throw new IllegalArgumentException("Stock insufficient or Product not found");
    }
  }
}
