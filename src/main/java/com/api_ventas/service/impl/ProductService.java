package com.api_ventas.service.impl;


import com.api_ventas.persistence.entities.Product;
import com.api_ventas.persistence.IProductDAO;
import com.api_ventas.presentation.exeptions.ResourceNotFoundException;
import com.api_ventas.service.IProductService;
import com.api_ventas.service.dto.ProductDTO;
import com.api_ventas.util.mappers.IProductMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

  private final IProductDAO productDAO;

  public ProductService (IProductDAO productDAO){
    this.productDAO = productDAO;
  }

  @Override
  public List<ProductDTO> findAll() {
    List<Product> productList =  productDAO.findAll();
    return IProductMapper.INSTANCE.productListToProductDTOList(productList);
  }

  @Override
  public Optional<ProductDTO> findById(Long id) {
    return productDAO.findById(id).map(IProductMapper.INSTANCE::productToProductDTO);
  }

  @Override
  public Long save(ProductDTO productDTO) {
    Product product = IProductMapper.INSTANCE.productDTOToProduct(productDTO);
    Product savedProduct = productDAO.save(product);
    return savedProduct.getId();
  }

  @Override
  public void update(ProductDTO productDTO) {
    Product product = productDAO.findById(productDTO.getId())
            .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado con ID: " + productDTO.getId()));

    product.setName(productDTO.getName());
    product.setDescription(productDTO.getDescription());
    product.setPicture(productDTO.getPicture());
    product.setPrice(productDTO.getPrice());
    product.setStock(productDTO.getStock());

    productDAO.update(product);
  }


  @Override
  public void deleteById(Long id) {
    if (productDAO.findById(id).isEmpty()) {
      throw new ResourceNotFoundException("No se puede eliminar. Producto con ID " + id + " no encontrado.");
    }
    productDAO.deleteById(id);
  }

  @Override
  public void updateStockAfterSale(Long productId, int quantitySold) {
    Product product = productDAO.findById(productId)
            .orElseThrow(() -> new ResourceNotFoundException("Producto con ID " + productId + " no encontrado."));

    if (product.getStock() < quantitySold) {
      throw new IllegalArgumentException("Stock insuficiente. Stock actual: " + product.getStock());
    }
    productDAO.updateStockAfterSale(productId, quantitySold);
  }
}
