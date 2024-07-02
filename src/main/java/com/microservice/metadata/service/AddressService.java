package com.microservice.metadata.service;

import java.util.List;

import com.microservice.metadata.entity.City;
import com.microservice.metadata.entity.Country;
import com.microservice.metadata.entity.State;

public interface AddressService {
	List<Country> getAllCountries();

    List<State> getStatesByCountryId(Long id);
    
    List<City> getCityByStateId(Long id);

}
