package com.microservice.metadata.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.metadata.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
