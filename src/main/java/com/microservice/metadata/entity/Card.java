package com.microservice.metadata.entity;

import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account accountType;

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    private List<BankService> bankServices;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Account getAccountType() {
		return accountType;
	}

	public void setAccountType(Account accountType) {
		this.accountType = accountType;
	}

	public List<BankService> getBankServices() {
		return bankServices;
	}

	public void setBankServices(List<BankService> bankServices) {
		this.bankServices = bankServices;
	}



    
}

