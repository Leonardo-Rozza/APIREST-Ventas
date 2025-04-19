package com.api_ventas.util.mappers;

import com.api_ventas.persistence.entities.Sale;
import com.api_ventas.service.dto.SaleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ISaleMapper {

  ISaleMapper INSTANCE = Mappers.getMapper(ISaleMapper.class);

  @Mapping(source = "customer.id", target = "customerId")
  @Mapping(source = "productForSaleLists", target = "productForSaleDTOList")
  SaleDTO saleToSaleDTO(Sale sale);

  List<SaleDTO> saleListToSaleDTOList(List<Sale> saleList);

  @Mapping(source = "customerId", target = "customer.id")
  @Mapping(source = "productForSaleDTOList", target = "productForSaleLists")
  Sale saleDTOToSale(SaleDTO saleDTO);
}
