package com.microservice.metadata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.metadata.entity.Account;
import com.microservice.metadata.entity.BankService;
import com.microservice.metadata.entity.Card;
import com.microservice.metadata.service.AccountService;
import com.microservice.metadata.service.BankServiceService;
import com.microservice.metadata.service.CardService;

@RestController
@RequestMapping("/api")
public class AccountsController {

	@Autowired
	private AccountService accountService;

	@Autowired
	private CardService cardService;

	@Autowired
	private BankServiceService bankServiceService;

	@GetMapping("/accounts")
	public List<Account> getAllAccounts() {
		return accountService.getAllAccounts();
	}

	@GetMapping("/accounts/{id}")
	public Account getAccountById(@PathVariable Long id) {
		return accountService.getAccountById(id);
	}

	@PostMapping("/accounts")
	public Account createAccount(@RequestBody Account account) {
		return accountService.createAccount(account);
	}

	// Card endpoints
	@GetMapping("/cards")
	public List<Card> getAllCards() {
		return cardService.getAllCards();
	}

	@GetMapping("/cards/{id}")
	public Card getCardById(@PathVariable Long id) {
		return cardService.getCardById(id);
	}

	@PostMapping("/cards")
	public Card createCard(@RequestBody Card card) {
		return cardService.createCard(card);
	}

	// BankService endpoints
	@GetMapping("/bankServices")
	public List<BankService> getAllBankServices() {
		return bankServiceService.getAllBankServices();
	}

	@GetMapping("/bankServices/{id}")
	public BankService getBankServiceById(@PathVariable Long id) {
		return bankServiceService.getBankServiceById(id);
	}

	@PostMapping("/bankServices")
	public BankService createBankService(@RequestBody BankService bankService) {
		return bankServiceService.createBankService(bankService);
	}
}
