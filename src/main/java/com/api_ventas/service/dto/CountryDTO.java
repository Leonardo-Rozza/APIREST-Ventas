package com.api_ventas.service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.validation.annotation.Validated;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class CountryDTO {
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacio")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    private String name;

    @NotBlank(message = "El nombre no puede estar vacio")
    private String domain;
}

