package com.microservice.metadata.service;

import java.util.List;

import com.microservice.metadata.entity.BankService;

public interface BankServiceService {
	List<BankService> getAllBankServices();

	BankService getBankServiceById(Long id);

	BankService createBankService(BankService bankService);
}
