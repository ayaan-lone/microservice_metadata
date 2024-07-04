package com.microservice.metadata.service;

import java.util.List;

import com.microservice.metadata.entity.Country;
import com.microservice.metadata.exception.MetadataException;
import com.microservice.metadata.response.CityDto;
import com.microservice.metadata.response.StateDto;

public interface AddressService {
	List<Country> getAllCountries();

	List<StateDto> getStatesByCountryId(Long id) throws MetadataException;

	List<CityDto> getCityByStateId(Long id) throws MetadataException;

}
