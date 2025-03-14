package com.api_ventas.persistence.impl;

import com.api_ventas.persistence.entities.Country;
import com.api_ventas.persistence.ICountryDAO;
import com.api_ventas.persistence.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CountryImpl implements ICountryDAO {

  private final CountryRepository countryRepository;

  @Autowired
  public CountryImpl(CountryRepository countryRepository){
    this.countryRepository = countryRepository;
  }

  @Override
  public List<Country> findAll() {
    return (List<Country>) countryRepository.findAll();
  }

  @Override
  public Optional<Country> findById(Long id) {
    return countryRepository.findById(id);
  }

  @Override
  public Country save(Country country) {
    return countryRepository.save(country);
  }

  @Override
  public void update(Country country) {
    Optional<Country> existingCountry = countryRepository.findById(country.getId());

    if (existingCountry.isPresent()) {
      countryRepository.save(country);
    } else {
      throw new IllegalArgumentException("Country not found");
    }
  }

  @Override
  public void deleteById(Long id) {
    countryRepository.deleteById(id);
  }
}
