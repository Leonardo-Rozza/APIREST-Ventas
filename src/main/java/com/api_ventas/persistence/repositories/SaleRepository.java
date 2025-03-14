package com.api_ventas.persistence.repositories;

import com.api_ventas.persistence.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

  @Query("SELECT s FROM Sale s WHERE s.customer.id = :customerId")
  List<Sale> findByCustomerId(@Param("customerId") Long customerId);

  @Query("SELECT s FROM Sale s JOIN s.productForSaleLists p WHERE p.product.id = :productId")
  List<Sale> findByProductId(@Param("productId") Long productId);
}