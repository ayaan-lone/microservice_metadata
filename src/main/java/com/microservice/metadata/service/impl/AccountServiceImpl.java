package com.microservice.metadata.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.metadata.dao.AccountRepository;
import com.microservice.metadata.entity.Account;
import com.microservice.metadata.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public List<Account> getAllAccounts() {
		return accountRepository.findAll();
	}

	@Override
	public Account getAccountById(Long id) {
		return accountRepository.findById(id).orElse(null);
	}

	@Override
	public Account createAccount(Account account) {
		return accountRepository.save(account);
	}
}
