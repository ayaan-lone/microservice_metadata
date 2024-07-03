package com.microservice.metadata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.metadata.entity.City;
import com.microservice.metadata.entity.Country;
import com.microservice.metadata.entity.State;
import com.microservice.metadata.exception.MetadataException;
import com.microservice.metadata.service.AddressService;
@RequestMapping("/api/v1/")
@RestController
public class AddressController {
	
	
	private final AddressService addressService;
	
	@Autowired
	public AddressController(  AddressService addressService) {
		this.addressService= addressService;
	}
	
	@GetMapping("country")
	public ResponseEntity<List<Country>> getAllCountries(){
		
		List<Country> response = addressService.getAllCountries();
		return  ResponseEntity.status(HttpStatus.OK).body(response);
		
	}
	
	
	@GetMapping("country/{id}/state")
	public ResponseEntity<List<State>> getAllStates(@PathVariable Long id) throws MetadataException{
		List<State> response = addressService.getStatesByCountryId(id);
		return  ResponseEntity.status(HttpStatus.OK).body(response);
		
	}
	
	@GetMapping("state/{stateId}/city")
	public ResponseEntity<List<City>> getAllCities(@PathVariable Long stateId) throws MetadataException{
		List<City> response = addressService.getCityByStateId(stateId);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

//	
//	@GetMapping("country/{countryId}/state/{stateId}/city")
//	public ResponseEntity<List<City>> getAllCitiesFromCountry(@PathVariable Long countryId, @PathVariable Long stateId){
//		List<City> response = addressService.getCityByCountryAndStateId(countryId, stateId);
//		return ResponseEntity.status(HttpStatus.OK).body(response);
//	}
}
