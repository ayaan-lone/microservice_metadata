package com.microservice.metadata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.metadata.entity.Country;
import com.microservice.metadata.exception.MetadataException;
import com.microservice.metadata.response.CityDto;
import com.microservice.metadata.response.StateDto;
import com.microservice.metadata.service.AddressService;

@RequestMapping("/api/v1/")
@RestController
public class AddressController {

	private final AddressService addressService;

	@Autowired
	public AddressController(AddressService addressService) {
		this.addressService = addressService;
	}

	@GetMapping("country")
	public ResponseEntity<List<Country>> getAllCountries() {

		List<Country> response = addressService.getAllCountries();
		return ResponseEntity.status(HttpStatus.OK).body(response);

	}

	@GetMapping("country/{id}/state")
	public ResponseEntity<List<StateDto>> getAllStates(@PathVariable Long id) throws MetadataException {
		List<StateDto> response = addressService.getStatesByCountryId(id);
		return ResponseEntity.status(HttpStatus.OK).body(response);

	}

	@GetMapping("state/{stateId}/city")
	public ResponseEntity<List<CityDto>> getAllCities(@PathVariable Long stateId) throws MetadataException {
		List<CityDto> response = addressService.getCityByStateId(stateId);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}


}
