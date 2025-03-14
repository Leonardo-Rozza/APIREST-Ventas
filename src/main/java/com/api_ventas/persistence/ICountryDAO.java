package com.api_ventas.persistence;

import com.api_ventas.persistence.entities.Country;

import java.util.List;
import java.util.Optional;

public interface ICountryDAO {

  List<Country> findAll();
  Optional<Country> findById(Long id);
  Country save(Country country);
  void update(Country country);
  void deleteById(Long id);

}
