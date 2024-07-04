package com.microservice.metadata.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.metadata.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {

}
