package com.microservice.metadata.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.metadata.dao.CountryRepository;
import com.microservice.metadata.dao.StateRepository;
import com.microservice.metadata.entity.Country;
import com.microservice.metadata.entity.State;
import com.microservice.metadata.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	private final CountryRepository countryRepository;
	private final StateRepository stateRepository;

	@Autowired
	public AddressServiceImpl(CountryRepository countryRepository, StateRepository stateRepository) {
		super();
		this.countryRepository = countryRepository;
		this.stateRepository = stateRepository;
	}

	@Override
	public List<Country> getAllCountries() {
		return countryRepository.findAll();

	}

	@Override
	public List<State> getStatesByCountryId(Long countryId) {
		return stateRepository.findByCountryId(countryId);
	}

}
