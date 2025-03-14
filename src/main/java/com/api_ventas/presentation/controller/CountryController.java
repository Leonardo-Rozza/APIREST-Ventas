package com.api_ventas.presentation.controller;

import com.api_ventas.service.ICountryService;
import com.api_ventas.service.dto.CountryDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

  private final ICountryService countryService;

  public CountryController (ICountryService countryService){
    this.countryService = countryService;
  }

  @GetMapping
  public ResponseEntity<List<CountryDTO>> getAllCountries() {
    return ResponseEntity.ok(countryService.findAll());
  }

  // Obtener un país por ID
  @GetMapping("/{id}")
  public ResponseEntity<CountryDTO> getCountryById(@PathVariable Long id) {
    Optional<CountryDTO> countryOptional= countryService.findById(id);
    return countryOptional
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
  }

  // Crear un nuevo país
  @PostMapping
  public ResponseEntity<Void> createCountry(@RequestBody CountryDTO countryDTO) throws URISyntaxException {
    Long countryId = countryService.save(countryDTO);
    return  ResponseEntity.created(new URI("/api/countries/" + countryId)).build();
  }

  // Actualizar un país existente
  @PutMapping("/{id}")
  public ResponseEntity<Void> updateCountry(@PathVariable Long id, @RequestBody @Valid CountryDTO countryDTO) {
    countryDTO.setId(id);  // Asegurar que el ID coincida con la URL
    countryService.update(countryDTO);
    return  ResponseEntity.noContent().build();
  }

  // Eliminar un país
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteCountry(@PathVariable Long id) {
    countryService.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
