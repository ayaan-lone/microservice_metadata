package com.microservice.metadata.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
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
import com.microservice.metadata.response.CityDto;
import com.microservice.metadata.response.StateDto;
import com.microservice.metadata.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	private final CountryRepository countryRepository;
	private final StateRepository stateRepository;
	private final CityRepository cityRepository;
	private final ModelMapper modelMapper;

	@Autowired
	public AddressServiceImpl(CountryRepository countryRepository, StateRepository stateRepository,
			CityRepository cityRepository, ModelMapper modelMapper) {
		super();
		this.countryRepository = countryRepository;
		this.stateRepository = stateRepository;
		this.cityRepository = cityRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public List<Country> getAllCountries() {
		return countryRepository.findAll();
	}

	@Override
	public List<StateDto> getStatesByCountryId(Long countryId) throws MetadataException {
		if (countryRepository.findById(countryId) == null) {
			throw new MetadataException(HttpStatus.NOT_FOUND, "Country not found");
		}
		List<State> states = stateRepository.findByCountryId(countryId);

		return states.stream().map(state -> modelMapper.map(state, StateDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<CityDto> getCityByStateId(Long stateId) throws MetadataException {
		if (stateRepository.findById(stateId) == null) {
			throw new MetadataException(HttpStatus.NOT_FOUND, "State not found");
		}
		List<City> cities = cityRepository.findByStateId(stateId);
		return cities.stream().map(city -> modelMapper.map(city, CityDto.class)).collect(Collectors.toList());

	}

}
