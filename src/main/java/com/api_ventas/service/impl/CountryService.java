package com.api_ventas.service.impl;


import com.api_ventas.persistence.entities.Country;
import com.api_ventas.util.mappers.ICountryMapper;
import com.api_ventas.persistence.ICountryDAO;
import com.api_ventas.service.ICountryService;
import com.api_ventas.service.dto.CountryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService implements ICountryService {

  private  final ICountryDAO countryDAO;

  @Autowired
  public CountryService(ICountryDAO countryDAO){
    this.countryDAO = countryDAO;
  }

  @Override
  public List<CountryDTO> findAll() {
    List<Country> countryList = countryDAO.findAll();
    return ICountryMapper.INSTANCE.countryListToCountryDTOList(countryList);
  }

  @Override
  public Optional<CountryDTO> findById(Long id) {
    Optional<Country> countryOptional = countryDAO.findById(id);
    if (countryOptional.isPresent()) {
      CountryDTO countryDTO = ICountryMapper.INSTANCE.countryToCountryDTO(countryOptional.get());
      return Optional.of(countryDTO);
    }
    return Optional.empty();
  }


  @Override
  public Long save(CountryDTO countryDTO) {
    Country country = ICountryMapper.INSTANCE.countryDTOToCountry(countryDTO);
    Country savedCountry = countryDAO.save(country);
    return  savedCountry.getId();
  }

  @Override
  public void update(CountryDTO countryDTO) {
    Optional<Country> existingCountry = countryDAO.findById(countryDTO.getId());

    if (existingCountry.isPresent()){
      Country country = ICountryMapper.INSTANCE.countryDTOToCountry(countryDTO);
      countryDAO.save(country);
    } else{
      throw new IllegalArgumentException("Country not found");
    }
  }

  @Override
  public void deleteById(Long id) {
    countryDAO.deleteById(id);
  }
}
