package com.example.demo.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.demo.dto.transactionDto;
import com.example.demo.entity.Account;
import com.example.demo.entity.Customer;
import com.example.demo.repository.AccountRepository;

import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.TransactionRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private TransactionRepository transactionRepository;

//	@Autowired
//	Customer1Repository repository; 

	@Override
	public String createAccount(Customer customer, String accountType, int balance) {
//		if(customer.getAge()>=18) {

		customerRepository.save(customer);
		Account account = new Account();
		account.setCid(customer.getCid());
		account.setAccountType(accountType);
		account.setBalance(balance);
		account.setCid(customer.getCid());
		accountRepository.save(account);

//		}
		return "Account is Successfully created";

	}

	@Override
	public List<transactionDto> getGenerateStatement(long accountNumber, Date transactionDate) {
		// TODO Auto-generated method stub
		Account account = accountRepository.findByAccountNumber(accountNumber);
		if (account != null) {
			List<transactionDto> credit = transactionRepository.findByAccountNumberAndTransactionDate(accountNumber,
					transactionDate);
			for (transactionDto dto : credit)
				dto.setStatus("Credit");
			List<transactionDto> debit = transactionRepository.findByAccountNumberAndTransactionDate1(accountNumber,
					transactionDate);
			for (transactionDto dto : debit)
				dto.setStatus("debit");
			credit.addAll(debit);
			return credit;
		} else {
			System.out.println("Account not found");
			return null;
		}
	}

//	@Override
//	public String createAccount(Customer1 customer) {
//		// TODO Auto-generated method stub
//		repository.save(customer);
//		return "ok";
//	}
}
