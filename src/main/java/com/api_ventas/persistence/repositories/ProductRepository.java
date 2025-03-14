package com.api_ventas.persistence.repositories;

import com.api_ventas.persistence.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

  @Modifying
  @Transactional
  @Query("UPDATE Product p SET p.stock = p.stock - :quantitySold WHERE p.id = :productId AND p.stock >= :quantitySold")
  int updateStockAfterSale(Long productId, int quantitySold);


}
