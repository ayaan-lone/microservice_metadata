package com.microservice.metadata.service;

import java.util.List;

import com.microservice.metadata.entity.City;
import com.microservice.metadata.entity.Country;
import com.microservice.metadata.entity.State;
import com.microservice.metadata.exception.MetadataException;

public interface AddressService {
	List<Country> getAllCountries();

    List<State> getStatesByCountryId(Long id) throws MetadataException;
    
    List<City> getCityByStateId(Long id) throws MetadataException;
//    List<City> getCityByCountryAndStateId(Long countryId, Long stateId);

}
