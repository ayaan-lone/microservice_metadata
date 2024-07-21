package com.microservice.metadata.service;

import java.util.List;

import com.microservice.metadata.entity.Card;
import com.microservice.metadata.exception.MetadataException;

public interface CardService {
	List<Card> getAllCards();

	Card getCardById(Long id);

	Card createCard(Card card);

	List<Card> getCardByAccountId(Long id) throws MetadataException;
}
