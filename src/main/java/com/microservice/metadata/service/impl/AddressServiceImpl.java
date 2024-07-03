package com.microservice.metadata.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.microservice.metadata.dao.CityRepository;
import com.microservice.metadata.dao.CountryRepository;
import com.microservice.metadata.dao.StateRepository;
import com.microservice.metadata.entity.City;
import com.microservice.metadata.entity.Country;
import com.microservice.metadata.entity.State;
import com.microservice.metadata.exception.MetadataException;
import com.microservice.metadata.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	private final CountryRepository countryRepository;
	private final StateRepository stateRepository;
	private final CityRepository cityRepository;

	@Autowired
	public AddressServiceImpl(CountryRepository countryRepository, StateRepository stateRepository, CityRepository cityRepository) {
		super();
		this.countryRepository = countryRepository;
		this.stateRepository = stateRepository;
		this.cityRepository = cityRepository;
	}

	@Override
	public List<Country> getAllCountries() {
		return countryRepository.findAll();

	}

	@Override
	public List<State> getStatesByCountryId(Long countryId) throws MetadataException {
		List<State> states = stateRepository.findByCountryId(countryId);
		if(states.isEmpty()) {
			throw new MetadataException(HttpStatus.NOT_FOUND, "State not found");
		}
		return states;
	}

	@Override
	public List<City> getCityByStateId(Long stateId) throws MetadataException{
		List<City> cities = cityRepository.findByStateId(stateId);
		if(cities.isEmpty()) {
			throw new MetadataException(HttpStatus.NOT_FOUND, "City not found");
		}
		return cities;
	}

//	@Override
//	public List<City> getCityByCountryAndStateId(Long countryId, Long stateId) {
//		return cityRepository.findByCountryIdAndStateId(countryId, stateId);
//		
//	}

}
