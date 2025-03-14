package com.api_ventas.util.mappers;


import com.api_ventas.persistence.entities.Customer;
import com.api_ventas.service.dto.CustomerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ICustomerMapper {
  ICustomerMapper INSTANCE = Mappers.getMapper(ICustomerMapper.class);

  // Customer a customerDTO
  CustomerDTO customerToCustomerDTO (Customer customer);

  // Mapea una lista de Customer a una lista de CustomerDTO
  List<CustomerDTO> customerListToCustomerDTOList (List<Customer> customerList);

  //mapeo inverso
  Customer customerDTOToCustomer(CustomerDTO customerDTO);

}
