package com.api_ventas.util.mappers;

import com.api_ventas.persistence.entities.Product;
import com.api_ventas.service.dto.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface IProductMapper {

  IProductMapper INSTANCE = Mappers.getMapper(IProductMapper.class);

  ProductDTO productToProductDTO (Product product);

  // Mapea una lista de Product a una lista de ProductDTO
  List<ProductDTO> productListToProductDTOList(List<Product> products);

  // Si querés el mapeo inverso
  Product productDTOToProduct(ProductDTO productDTO);

}
