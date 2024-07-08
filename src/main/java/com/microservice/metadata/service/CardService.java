package com.microservice.metadata.service;

import java.util.List;

import com.microservice.metadata.entity.Card;

public interface CardService {
	List<Card> getAllCards();

	Card getCardById(Long id);

	Card createCard(Card card);
}
