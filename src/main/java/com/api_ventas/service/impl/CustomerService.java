package com.api_ventas.service.impl;

import com.api_ventas.persistence.entities.Customer;
import com.api_ventas.persistence.ICustomerDAO;
import com.api_ventas.service.ICustomerService;
import com.api_ventas.service.dto.CustomerDTO;
import com.api_ventas.util.mappers.ICustomerMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

  private final ICustomerDAO customerDAO;

  public CustomerService(ICustomerDAO customerDAO){
    this.customerDAO = customerDAO;
  }

  @Override
  public List<CustomerDTO> findAll() {
    List<Customer> customerList = customerDAO.findAll();
    return ICustomerMapper.INSTANCE.customerListToCustomerDTOList(customerList);
  }

  @Override
  public Optional<CustomerDTO> findById(Long id) {
    Optional<Customer> customerOptional = customerDAO.findById(id);
    return customerOptional.map(ICustomerMapper.INSTANCE::customerToCustomerDTO);
  }

  @Override
  public Long save(CustomerDTO customerDTO) {
    Customer customer = ICustomerMapper.INSTANCE.customerDTOToCustomer(customerDTO);
    Customer savedCustomer = customerDAO.save(customer);
    return savedCustomer.getId();
  }

  @Override
  public void deleteById(Long id) {
    customerDAO.deleteById(id);
  }

  @Override
  public void update(CustomerDTO customerDTO) {
    Optional<Customer> existingCustomer = customerDAO.findById(customerDTO.getId());

    if (existingCustomer.isPresent()){
      Customer customer = ICustomerMapper.INSTANCE.customerDTOToCustomer(customerDTO);
      customerDAO.save(customer);
    } else{
      throw new IllegalArgumentException("Country not found");
    }
  }
}
