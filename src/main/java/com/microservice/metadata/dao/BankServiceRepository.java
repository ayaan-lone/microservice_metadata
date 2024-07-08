package com.microservice.metadata.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.metadata.entity.BankService;


public interface BankServiceRepository  extends JpaRepository<BankService, Long> {

}
