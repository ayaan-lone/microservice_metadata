package com.microservice.metadata.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.metadata.entity.State;

public interface StateRepository extends JpaRepository<State, Long> {
	List<State> findByCountryId(Long countryId);
}
