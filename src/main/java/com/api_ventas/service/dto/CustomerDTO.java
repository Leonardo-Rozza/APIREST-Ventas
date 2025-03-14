package com.api_ventas.service.dto;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

  private Long id;

  @NotBlank(message = "El nombre no puede estar vacio")
  @Size(min =2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
  private String name;

  @NotBlank(message = "El apellido no puede estar vacio")
  @Size(min =2, max = 50, message = "El apellido debe tener entre 2 y 50 caracteres")
  private String lastName;

  @Size(min = 10, max = 30, message = "El numero de teléfono debe tener entre 10 y 30 caracteres")
  @NotBlank(message = "El nombre no puede estar vacio")
  private String phone;

  @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
  @Size(min =2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
  @NotBlank(message = "El email no puede estar vacio")
  private String email;

  @Size(min =2, max = 200, message = "La dirección debe tener entre 2 y 200 caracteres")
  @NotBlank(message = "La dirección no puede estar vacia")
  private String address;

  @Size(min =2, max = 6, message = "El código postal debe tener entre 2 y 6 caracteres")
  @NotBlank(message = "El código postal no puede estar vacio")
  private String cp;

  @Size(min =2, max = 150, message = "El nombre debe tener entre 2 y 150 caracteres")
  @NotBlank(message = "La cuidad no puede estar vacio")
  private String city;

  @Valid
  private CountryDTO countryDTO;

}
