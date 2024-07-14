package com.microservice.metadata.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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

import com.microservice.metadata.dao.AccountRepository;
import com.microservice.metadata.dao.CardRepository;
import com.microservice.metadata.entity.Account;
import com.microservice.metadata.entity.Card;
import com.microservice.metadata.service.impl.AccountServiceImpl;

@ExtendWith(MockitoExtension.class)
public class AccountServiceImplTest {

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private CardRepository cardRepository;

    @InjectMocks
    private AccountServiceImpl accountServiceImpl;

    private Account account;
    private Card card;

    @BeforeEach
    void setUp() {
        account = new Account();
        account.setId(1L);
        account.setName("Savings");

        card = new Card();
        card.setId(1L);
        card.setName("Credit");
    }

    @Test
    void testGetAllAccounts() {
        when(accountRepository.findAll()).thenReturn(Arrays.asList(account));

        List<Account> accounts = accountServiceImpl.getAllAccounts();

        assertEquals(1, accounts.size());
        assertEquals("Savings", accounts.get(0).getName());
        verify(accountRepository).findAll();
    }
 
    @Test
    void testGetAccountById_Success() {
        when(accountRepository.findById(1L)).thenReturn(Optional.of(account));

        Account foundAccount = accountServiceImpl.getAccountById(1L);

        assertEquals("Savings", foundAccount.getName());
        verify(accountRepository).findById(1L);
    }

    @Test
    void testGetAccountById_NotFound() {
        when(accountRepository.findById(1L)).thenReturn(Optional.empty());

        Account foundAccount = accountServiceImpl.getAccountById(1L);

        assertEquals(null, foundAccount);
        verify(accountRepository).findById(1L);
    }

    @Test
    void testCreateAccount() {
        when(accountRepository.save(account)).thenReturn(account);

        Account createdAccount = accountServiceImpl.createAccount(account);

        assertEquals("Savings", createdAccount.getName());
        verify(accountRepository).save(account);
    }

    @Test
    void testGetAccountTypeByAccountId_Success() {
        when(accountRepository.findById(1L)).thenReturn(Optional.of(account));

        String accountType = accountServiceImpl.getAccountTypeByAccountId(1L);

        assertEquals("Savings", accountType);
        verify(accountRepository).findById(1L);
    }

    @Test
    void testGetAccountTypeByAccountId_NotFound() {
        when(accountRepository.findById(1L)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            accountServiceImpl.getAccountTypeByAccountId(1L);
        });

        assertEquals("Account not found with id: 1", exception.getMessage());
        verify(accountRepository).findById(1L);
    }

    @Test
    void testGetCardTypeByAccountId_Success() {
        when(cardRepository.findById(1L)).thenReturn(Optional.of(card));

        String cardType = accountServiceImpl.getCardTypeByAccountId(1L);

        assertEquals("Credit", cardType);
        verify(cardRepository).findById(1L);
    }

    @Test
    void testGetCardTypeByAccountId_NotFound() {
        when(cardRepository.findById(1L)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            accountServiceImpl.getCardTypeByAccountId(1L);
        });

        assertEquals("Account not found with id: 1", exception.getMessage());
        verify(cardRepository).findById(1L);
    }
}
