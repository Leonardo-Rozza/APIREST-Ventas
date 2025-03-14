package com.api_ventas.service.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductForSaleDTO {

  private Long id;

  private Long productId;

  private Long saleId;

  private int quantity;
}
