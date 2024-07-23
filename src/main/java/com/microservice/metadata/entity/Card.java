package com.microservice.metadata.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    
    

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

	@ManyToOne
    @JoinColumn(name = "account_id")
    private Account accountType;

	
    public Integer getDaily_limit() {
		return daily_limit;
	}

	public void setDaily_limit(Integer daily_limit) {
		this.daily_limit = daily_limit;
	}

	public Integer getMonthly_limit() {
		return monthly_limit;
	}

	public void setMonthly_limit(Integer monthly_limit) {
		this.monthly_limit = monthly_limit;
	}


	public Integer daily_limit;
    public Integer monthly_limit;


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


    
}

