package com.api_ventas.service;

import com.api_ventas.service.dto.CustomerDTO;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {


  List<CustomerDTO> findAll();
  Optional<CustomerDTO> findById(Long id); //Por si no existe y llega null.
  Long save(CustomerDTO customerDTO);
  void deleteById(Long id);
  void update(CustomerDTO customerDTO);
}
