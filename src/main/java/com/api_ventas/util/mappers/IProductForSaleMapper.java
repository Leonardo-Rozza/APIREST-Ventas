package com.api_ventas.util.mappers;

import com.api_ventas.persistence.entities.ProductForSale;
import com.api_ventas.service.dto.ProductForSaleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface IProductForSaleMapper {
  IProductForSaleMapper INSTANCE = Mappers.getMapper(IProductForSaleMapper.class);

  // ProductForSale a ProductForSaleDTO

  @Mapping(source = "product.id", target = "productId")
  @Mapping(source = "sale.id", target = "saleId")
  ProductForSaleDTO productForSaleToProductForSaleDTO (ProductForSale productForSale);

  // Mapea una lista de ProductForSale a una lista de ProductForSaleDTO
  List<ProductForSaleDTO> prodoductForSaleListToProductForSaleDTOList(List<ProductForSale> productForSaleList);


  @Mapping(source = "productId", target = "product.id")
  @Mapping(source = "saleId", target = "sale.id")
  //mapeo inverso
  ProductForSale productForSaleDTOToProductForSale(ProductForSaleDTO productForSaleDTO);

}
