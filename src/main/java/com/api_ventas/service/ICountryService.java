package com.api_ventas.service;

import com.api_ventas.service.dto.CountryDTO;

import java.util.List;
import java.util.Optional;

public interface ICountryService {

  List<CountryDTO> findAll();
  Optional<CountryDTO> findById(Long id);
  Long save(CountryDTO countryDTO);
  void update(CountryDTO countryDTO);
  void deleteById(Long id);
}
