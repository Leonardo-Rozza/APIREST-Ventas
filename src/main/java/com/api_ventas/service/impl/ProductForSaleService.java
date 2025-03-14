package com.api_ventas.service.impl;

import com.api_ventas.persistence.IProductDAO;
import com.api_ventas.persistence.IProductForSaleDAO;
import com.api_ventas.persistence.ISaleDAO;
import com.api_ventas.persistence.entities.Product;
import com.api_ventas.persistence.entities.ProductForSale;
import com.api_ventas.persistence.entities.Sale;
import com.api_ventas.presentation.exeptions.ResourceNotFoundException;
import com.api_ventas.service.IProductForSaleService;
import com.api_ventas.service.dto.ProductForSaleDTO;
import com.api_ventas.util.mappers.IProductForSaleMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductForSaleService implements IProductForSaleService {

  private final IProductForSaleDAO productForSaleDAO;
  private final IProductDAO productDAO;
  private final ISaleDAO saleDAO;


  public ProductForSaleService (IProductForSaleDAO productForSaleDAO,
                                IProductDAO productDAO,
                                ISaleDAO saleDAO){
    this.productForSaleDAO = productForSaleDAO;
    this.productDAO = productDAO;
    this.saleDAO = saleDAO;
  }

  @Override
  public List<ProductForSaleDTO> findAll() {
    return IProductForSaleMapper
            .INSTANCE.prodoductForSaleListToProductForSaleDTOList(productForSaleDAO.findAll());
  }

  @Override
  public Optional<ProductForSaleDTO> findById(Long id) {
    Optional<ProductForSale> productForSale = productForSaleDAO.findById(id);
    return productForSale.map(IProductForSaleMapper.INSTANCE::productForSaleToProductForSaleDTO);
  }

  @Override
  public Long save(ProductForSaleDTO productForSaleDTO) {
    ProductForSale productForSale = IProductForSaleMapper.INSTANCE.productForSaleDTOToProductForSale(productForSaleDTO);
    ProductForSale product = productForSaleDAO.save(productForSale);
    return product.getId();
  }

  @Override
  public void deleteById(Long id) {
    if (productForSaleDAO.findById(id).isEmpty()) {
      throw new ResourceNotFoundException("No se puede eliminar. Producto con ID " + id + " no encontrado.");
    }
    productForSaleDAO.deleteById(id);
  }

  @Override
  public void update(ProductForSaleDTO productForSaleDTO) {

  productForSaleDAO.findById(productForSaleDTO.getId()).ifPresent(existingProduct -> {

    existingProduct.setQuantity(productForSaleDTO.getQuantity());

    if (productForSaleDTO.getProductId() != null) {
      Product product = productDAO.findById(productForSaleDTO.getProductId())
          .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado"));
      existingProduct.setProduct(product);
    }

    if (productForSaleDTO.getSaleId() != null) {
      Sale sale = saleDAO.findById(productForSaleDTO.getSaleId())
          .orElseThrow(() -> new ResourceNotFoundException("Venta no encontrada"));
      existingProduct.setSale(sale);
    }

    productForSaleDAO.save(existingProduct);
    });
  }


  @Override
  public List<ProductForSaleDTO> findByProductId(Long productId) {
    return IProductForSaleMapper
            .INSTANCE.prodoductForSaleListToProductForSaleDTOList(productForSaleDAO.findByProductId(productId));
  }

  @Override
  public List<ProductForSaleDTO> findByCustomerId(Long customerId) {
    return IProductForSaleMapper
            .INSTANCE.prodoductForSaleListToProductForSaleDTOList(productForSaleDAO.findByCustomerId(customerId));
  }

  @Override
  public List<ProductForSaleDTO> findBySaleId(Long saleId) {
    return IProductForSaleMapper
            .INSTANCE.prodoductForSaleListToProductForSaleDTOList(productForSaleDAO.findBySaleId(saleId));
  }
}
