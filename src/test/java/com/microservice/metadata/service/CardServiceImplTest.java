package com.microservice.metadata.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.microservice.metadata.dao.CardRepository;
import com.microservice.metadata.entity.Card;
import com.microservice.metadata.service.impl.CardServiceImpl;

@ExtendWith(MockitoExtension.class)
public class CardServiceImplTest {

    @Mock
    private CardRepository cardRepository;

    @InjectMocks
    private CardServiceImpl cardServiceImpl;

    private Card card;

    @BeforeEach
    void setUp() {
        card = new Card();
        card.setId(1L);
        card.setName("Test Card");
    }

    @Test
    void testGetAllCards() {
        when(cardRepository.findAll()).thenReturn(Arrays.asList(card));

        List<Card> cards = cardServiceImpl.getAllCards();

        assertEquals(1, cards.size());
        assertEquals("Test Card", cards.get(0).getName());
        verify(cardRepository).findAll();
    }

    @Test
    void testGetCardById_Success() {
        when(cardRepository.findById(1L)).thenReturn(Optional.of(card));

        Card retrievedCard = cardServiceImpl.getCardById(1L);

        assertEquals(card, retrievedCard);
        verify(cardRepository).findById(1L);
    }

    @Test
    void testGetCardById_NotFound() {
        when(cardRepository.findById(1L)).thenReturn(Optional.empty());

        Card retrievedCard = cardServiceImpl.getCardById(1L);

        assertNull(retrievedCard);
        verify(cardRepository).findById(1L);
    }

    @Test
    void testCreateCard() {
        when(cardRepository.save(card)).thenReturn(card);

        Card createdCard = cardServiceImpl.createCard(card);

        assertEquals(card, createdCard);
        verify(cardRepository).save(card);
    }
}
