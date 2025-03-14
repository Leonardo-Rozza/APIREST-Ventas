package com.api_ventas.util.mappers;

import com.api_ventas.persistence.entities.Country;
import com.api_ventas.service.dto.CountryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ICountryMapper {

  ICountryMapper INSTANCE = Mappers.getMapper(ICountryMapper.class);

  CountryDTO countryToCountryDTO (Country country);

  // Mapea una lista de Country a una lista de CountryDTO
  List<CountryDTO> countryListToCountryDTOList(List<Country> countries);

  // Si querés el mapeo inverso
  Country countryDTOToCountry(CountryDTO countryDTO);

}
