package com.microservice.metadata.service;

import java.util.List;

import com.microservice.metadata.entity.Account;

public interface AccountService {
	List<Account> getAllAccounts();

	Account getAccountById(Long id);

	Account createAccount(Account account);
}
