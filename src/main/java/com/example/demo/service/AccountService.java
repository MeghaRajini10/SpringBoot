package com.example.demo.service;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.transactionDto;
import com.example.demo.entity.Customer;

public interface AccountService {

	String createAccount(Customer customer, String accountType, int balance);

	List<transactionDto> getGenerateStatement(long accountNumber, java.sql.Date transactionDate);

//	String createAccount(Customer1 customer);

}
