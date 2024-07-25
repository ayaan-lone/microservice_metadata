package com.microservice.metadata.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.metadata.entity.Card;

public interface CardRepository extends JpaRepository<Card, Long> {

	List<Card> findByAccountType_Id(Long accountId);

}
