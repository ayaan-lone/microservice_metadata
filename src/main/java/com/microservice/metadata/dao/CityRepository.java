package com.microservice.metadata.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.metadata.entity.City;

public interface CityRepository extends JpaRepository<City, Long> {
	List<City> findByStateId(Long stateId);

//	List<City> findByCountryIdAndStateId(Long countryId, Long stateId);
}
