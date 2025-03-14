package com.api_ventas.persistence;

import com.api_ventas.persistence.entities.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerDAO {

  List<Customer> findAll();
  Optional<Customer> findById(Long id); //Por si no existe y llega null.
  Customer save(Customer customer);
  void deleteById(Long id);
  void update(Customer customer);

}
