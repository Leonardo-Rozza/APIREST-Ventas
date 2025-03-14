package com.api_ventas.presentation.controller;


import com.api_ventas.service.ICustomerService;
import com.api_ventas.service.dto.CustomerDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

  private final ICustomerService customerService;

  public CustomerController(ICustomerService customerService){
    this.customerService = customerService;
  }

  @GetMapping
  public ResponseEntity<List<CustomerDTO>> getAllCustomers(){
    return ResponseEntity.ok(customerService.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<CustomerDTO> findById(@PathVariable Long id){
    Optional<CustomerDTO> customerDTO = customerService.findById(id);

    return customerDTO.map(ResponseEntity::ok)
            .orElseGet(() ->ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<Void> createCustomer(@RequestBody @Valid CustomerDTO customerDTO) throws URISyntaxException{
    Long id = customerService.save(customerDTO);
    return ResponseEntity.created(new URI("/api/customers" + id)).build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<Void> updateCustomer(@PathVariable Long id , @RequestBody @Valid CustomerDTO customerDTO){
    customerDTO.setId(id);
    customerService.update(customerDTO);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteCustomer(@PathVariable Long id){
    customerService.deleteById(id);
    return ResponseEntity.noContent().build();
  }







}
