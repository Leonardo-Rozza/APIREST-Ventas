package com.api_ventas.service.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

  private Long id;

  @NotBlank(message = "El nombre del producto no puede estar vacío.")
  private String name;

  @NotBlank(message = "La descripción no puede estar vacía.")
  private String description;

  private String picture;

  @NotNull(message = "El precio no puede ser nulo.")
  @DecimalMin(value = "0.01", message = "El precio debe ser mayor a 0.")
  private BigDecimal price;

  @Min(value = 0, message = "El stock no puede ser negativo.")
  private int stock;
}
