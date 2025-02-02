package com.microservice.metadata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.metadata.entity.Account;
import com.microservice.metadata.entity.Card;
import com.microservice.metadata.exception.MetadataException;
import com.microservice.metadata.response.CardResponseDto;
import com.microservice.metadata.service.AccountService;
import com.microservice.metadata.service.CardService;


@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:5500/")   
public class AccountsController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private CardService cardService;


	@GetMapping("/accounts")
	public List<Account> getAllAccounts() {
		return accountService.getAllAccounts();
	}

	@GetMapping("/accounts/{id}")
	public Account getAccountById(@PathVariable Long id) {
		return accountService.getAccountById(id);
	}

    // End-point to fetch account type by account ID
    @GetMapping("/accountType/{accountId}")
    public String getAccountTypeByAccountId(@PathVariable Long accountId) {
        return accountService.getAccountTypeByAccountId(accountId);
    }

	@PostMapping("/accounts")
	public Account createAccount(@RequestBody Account account) {
		return accountService.createAccount(account);
	}

	// Card End-points
	@GetMapping("/cards")
	public List<Card> getAllCards() {
		return cardService.getAllCards();
	}

	@GetMapping("/cards/{id}")
	public Card getCardById(@PathVariable Long id) {
		return cardService.getCardById(id);
	}
	
	// Fetch Card Data on the basis of AccountId
	@GetMapping("/account/cards/{accountId}")
	ResponseEntity<List<Card>> getCardByaccountId(@PathVariable Long accountId) throws MetadataException {
		List<Card> response = cardService.getCardByAccountId(accountId);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	
	 // End-point to fetch card type by account ID
    @GetMapping("/cardType/{accountId}")
    public CardResponseDto getCardTypeByAccountId(@PathVariable Long accountId) {
        return accountService.getCardTypeByAccountId(accountId);
    }

	@PostMapping("/cards")
	public Card createCard(@RequestBody Card card) {
		return cardService.createCard(card);
	}


}
