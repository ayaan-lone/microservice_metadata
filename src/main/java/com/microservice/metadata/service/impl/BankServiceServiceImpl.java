package com.microservice.metadata.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.metadata.dao.BankServiceRepository;
import com.microservice.metadata.entity.BankService;
import com.microservice.metadata.service.BankServiceService;

@Service
public class BankServiceServiceImpl implements BankServiceService {

	@Autowired
	private BankServiceRepository bankServiceRepository;

	@Override
	public List<BankService> getAllBankServices() {
		return bankServiceRepository.findAll();
	}

	@Override
	public BankService getBankServiceById(Long id) {
		return bankServiceRepository.findById(id).orElse(null);
	}

	@Override
	public BankService createBankService(BankService bankService) {
		return bankServiceRepository.save(bankService);
	}
}
