package com.example.demo.service;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Account;
import com.example.demo.entity.Transaction;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private AccountRepository accountRepository;

//	@Override
//	public String transferAmount(Account account,long fromAccountNumber, long toAccountNumber, float amount) {
//		Account account1=accountRepository.findByAccountNumber(fromAccountNumber);
//		Account account2=accountRepository.findByAccountNumber(toAccountNumber);
//		if(account1.getBalance()-amount>0) {
//			account1.setBalance(account1.getBalance()-amount);
//			account2.setBalance(account2.getBalance()+amount);
//			accountRepository.save(account1);
//			accountRepository.save(account2);
//			
//		}
//		return "Amount is successfully debited or credited";
//	}

	@Override
	public String transferAmount(long fromAccountNumber, long toAccountNumber, double amount, Date date) {
		// TODO Auto-generated method stub
		Account account1 = accountRepository.findByAccountNumber(fromAccountNumber);
		Account account2 = accountRepository.findByAccountNumber(toAccountNumber);
		if (account1.getBalance() - amount > 0) {
			account1.setBalance(account1.getBalance() - amount);
			account2.setBalance(account2.getBalance() + amount);
			accountRepository.save(account1);
			accountRepository.save(account2);

			Transaction transaction = new Transaction();
			transaction.setAmount(amount);
			transaction.setFromAccountNumber(fromAccountNumber);
			transaction.setToAccountNumber(toAccountNumber);
			transaction.setCreateDate(date);
			transactionRepository.save(transaction);

		}
		return "Amount is successfully debited or credited";
	}

}
