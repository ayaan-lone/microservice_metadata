package com.microservice.metadata.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.metadata.dao.CardRepository;
import com.microservice.metadata.entity.Card;
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
}
