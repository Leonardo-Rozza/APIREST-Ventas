package com.api_ventas.service.impl;

import com.api_ventas.persistence.ICustomerDAO;
import com.api_ventas.persistence.IProductDAO;
import com.api_ventas.persistence.entities.Customer;
import com.api_ventas.persistence.entities.Product;
import com.api_ventas.persistence.entities.ProductForSale;
import com.api_ventas.persistence.entities.Sale;
import com.api_ventas.persistence.ISaleDAO;
import com.api_ventas.presentation.exeptions.ResourceNotFoundException;
import com.api_ventas.service.ISaleService;
import com.api_ventas.service.dto.SaleDTO;
import com.api_ventas.util.mappers.ISaleMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SaleService implements ISaleService {

  private final ISaleDAO saleDAO;
  private final ICustomerDAO customerDAO;
  private final IProductDAO productDAO;

  public SaleService(ISaleDAO saleDAO, ICustomerDAO customerDAO, IProductDAO productDAO) {
    this.saleDAO = saleDAO;
    this.customerDAO = customerDAO;
    this.productDAO = productDAO;
  }


  @Override
  public List<SaleDTO> findAll() {
    List<Sale> saleList = saleDAO.findAll();
    return ISaleMapper.INSTANCE.saleListToSaleDTOList(saleList);
  }

  @Override
  public Optional<SaleDTO> findById(Long id) {
    return saleDAO.findById(id).map(ISaleMapper.INSTANCE::saleToSaleDTO);
  }

  @Override
  public Long save(SaleDTO saleDTO) {
    Sale sale = ISaleMapper.INSTANCE.saleDTOToSale(saleDTO);
    Sale savedSale = saleDAO.save(sale);
    return savedSale.getId();
  }

  @Override
  public void update(SaleDTO saleDTO) {
    saleDAO.findById(saleDTO.getId()).ifPresent(existingSale -> {

      // Actualizar los campos básicos
      existingSale.setDate(saleDTO.getDate());
      existingSale.setTotal(saleDTO.getTotal());

      // Actualizar el cliente si el customerId está presente
      if (saleDTO.getCustomerId() != null) {
        Customer customer = customerDAO.findById(saleDTO.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"));
        existingSale.setCustomer(customer);
      }

      // Actualizar la lista de productos
      if (saleDTO.getProductForSaleDTOList() != null) {
        List<ProductForSale> updatedProducts = saleDTO.getProductForSaleDTOList().stream()
                .map(productForSaleDTO -> {
                  ProductForSale productForSale = new ProductForSale();
                  // Aquí deberías mapear los datos de ProductForSaleDTO a ProductForSale
                  productForSale.setQuantity(productForSaleDTO.getQuantity());
                  if (productForSaleDTO.getProductId() != null) {
                    Product product = productDAO.findById(productForSaleDTO.getProductId())
                            .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado"));
                    productForSale.setProduct(product);
                  }
                  productForSale.setSale(existingSale);
                  return productForSale;
                })
                .collect(Collectors.toList());

        existingSale.setProductForSaleLists(updatedProducts);
      }

      // Guardar la entidad Sale actualizada
      saleDAO.save(existingSale);
    });
  }

  @Override
  public void deleteById(Long id) {
    if (saleDAO.findById(id).isEmpty()) {
      throw new ResourceNotFoundException("No se puede eliminar. Venta con ID " + id + " no encontrada.");
    }
    saleDAO.deleteById(id);
  }

  @Override
  public List<SaleDTO> findByCustomerId(Long customerId) {
    List<Sale> saleList = saleDAO.findByCustomerId(customerId);
    return ISaleMapper.INSTANCE.saleListToSaleDTOList(saleList);
  }

  @Override
  public List<SaleDTO> findByProductId(Long productId) {
    List<Sale> saleList = saleDAO.findByProductId(productId);  // Corrección aquí
    return ISaleMapper.INSTANCE.saleListToSaleDTOList(saleList);
  }
}
