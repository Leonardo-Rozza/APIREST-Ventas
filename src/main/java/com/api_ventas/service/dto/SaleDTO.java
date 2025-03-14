package com.api_ventas.service.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleDTO {

  @NotNull(message = "El ID no puede ser nulo.")
  private Long id;

  @NotNull(message = "La fecha de la venta no puede ser nula.")
  private LocalDate date;

  @NotNull(message = "El total de la venta no puede ser nulo.")
  @Positive(message = "El total debe ser un valor positivo.")
  private BigDecimal total;

  @NotNull(message = "El ID del cliente no puede ser nulo.")
  private Long customerId;

  @Size(min = 1, message = "Debe haber al menos un producto en la venta.")
  private List<ProductForSaleDTO> productForSaleDTOList;

}
