package com.microservice.metadata.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.microservice.metadata.dao.CardRepository;
import com.microservice.metadata.entity.Card;
import com.microservice.metadata.exception.MetadataException;
import com.microservice.metadata.service.CardService;

@Service
public class CardServiceImpl implements CardService {

	@Autowired
	private CardRepository cardRepository;

	@Override
	public List<Card> getAllCards() {
		return cardRepository.findAll();
	}

	@Override
	public Card getCardById(Long id) {
		return cardRepository.findById(id).orElse(null);
	}

	@Override
	public Card createCard(Card card) {
		return cardRepository.save(card);

	}

	@Override
	public List<Card>  getCardByAccountId(Long accountId) throws MetadataException {
		
		List<Card> cards = cardRepository.findByAccountType_Id(accountId);
		if(cards.size()==0) {
			throw new MetadataException(HttpStatus.NOT_FOUND, "No Card Associated with the provided AccountId.");
		}
		
		return cards;
	}
}
