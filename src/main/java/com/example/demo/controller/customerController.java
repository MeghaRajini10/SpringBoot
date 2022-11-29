package com.example.demo.controller;

import java.sql.Date;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.transactionDto;
import com.example.demo.entity.Account;
import com.example.demo.entity.Customer;
import com.example.demo.service.AccountService;
import com.example.demo.service.AccountServiceImpl;

import com.example.demo.service.TransactionService;

@RestController
public class customerController {
	@Autowired
	AccountService accountService;

	@PostMapping("/CreateAccount")
	public String createAccount(@RequestBody Customer customer, @RequestParam String accountType,
			@RequestParam @Min(value = 500, message = "minimum balance should be 500") int balance) {
//		@Size(max = 2) 
		return accountService.createAccount(customer, accountType, balance);
	}

//	@PostMapping("/CreateAccount1")
//	public String createAccount1(@RequestBody Customer1 customer) {
//		
//		return accountService.createAccount(customer);
//	}

	@Autowired
	TransactionService transactionService;

	@PostMapping("/TransferAmounts")
	public String transferAmount(@RequestParam long fromAccountNumber, @RequestParam long toAccountNumber,
			@RequestParam float amount, @RequestParam Date date) {
		return transactionService.transferAmount(fromAccountNumber, toAccountNumber, amount, date);

	}

	@GetMapping("/GenerateStatements")
	public List<transactionDto> getGenerateStatement(@RequestParam long accountNumber,
			@RequestParam Date transactionDate) {
		return accountService.getGenerateStatement(accountNumber, transactionDate);
	}

}
