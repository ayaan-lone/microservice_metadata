package com.microservice.metadata.service;

import java.util.List;

import com.microservice.metadata.entity.Account;
import com.microservice.metadata.response.CardResponseDto;

public interface AccountService {
	List<Account> getAllAccounts();

	Account getAccountById(Long id);

	Account createAccount(Account account);

	String getAccountTypeByAccountId(Long accountId);

	CardResponseDto getCardTypeByAccountId(Long accountId);
}
