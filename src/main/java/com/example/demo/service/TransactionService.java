package com.example.demo.service;

import java.sql.Date;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Account;

public interface TransactionService {

	String transferAmount(long fromAccountNumber, long toAccountNumber, double amount, Date date);

}
