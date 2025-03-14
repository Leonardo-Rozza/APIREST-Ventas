package com.api_ventas.persistence.impl;

import com.api_ventas.persistence.entities.Customer;
import com.api_ventas.persistence.ICustomerDAO;
import com.api_ventas.persistence.repositories.CustomerRespository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerImpl implements ICustomerDAO {

  private final CustomerRespository customerRespository;

  public CustomerImpl(CustomerRespository customerRespository){
    this.customerRespository = customerRespository;
  }

  @Override
  public List<Customer> findAll() {
    return customerRespository.findAll();
  }

  @Override
  public Optional<Customer> findById(Long id) {
    return customerRespository.findById(id);
  }

  @Override
  public Customer save(Customer customer) {
    return customerRespository.save(customer);
  }

  @Override
  public void deleteById(Long id) {
    customerRespository.deleteById(id);
  }

  @Override
  public void update(Customer customer) {
    Optional<Customer> existingCustomer = customerRespository.findById(customer.getId());

    if (existingCustomer.isPresent()){
      customerRespository.save(customer);
    }else {
      throw new IllegalArgumentException("Customer not found");
    }


  }
}
