package com.microservice.metadata.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.metadata.entity.Card;

public interface CardRepository extends JpaRepository<Card, Long> {

}
