package com.api_ventas.persistence.repositories;

import com.api_ventas.persistence.entities.ProductForSale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductForSaleRepository extends JpaRepository<ProductForSale, Long> {

  @Query("SELECT p FROM ProductForSale p JOIN p.sale s WHERE s.customer.id = :customerId")
  List<ProductForSale> findByCustomerId(@Param("customerId") Long customerId);

  @Query("SELECT p FROM ProductForSale p WHERE p.sale.id = :saleId")
  List<ProductForSale> findBySaleId(@Param("saleId") Long saleId);

  @Query("SELECT p FROM ProductForSale p WHERE p.product.id = :productId")
  List<ProductForSale> findByProductId(@Param("productId") Long productId);
}