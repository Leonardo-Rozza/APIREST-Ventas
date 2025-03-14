package com.api_ventas.persistence.repositories;

import com.api_ventas.persistence.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRespository extends JpaRepository<Customer, Long> {
}
