package com.example.demo.repository;

import java.time.Month;
import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.transactionDto;
import com.example.demo.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

	Date findBycreateDate(Date createDate);

//	Month findByMonth(Month month);

	@Query("Select new com.example.demo.dto.transactionDto(amount,fromAccountNumber) from Transaction where createDate=:transactionDate and toAccountNumber=:accountNumber")
	List<transactionDto> findByAccountNumberAndTransactionDate(long accountNumber, java.sql.Date transactionDate);

	@Query("Select new com.example.demo.dto.transactionDto(amount,toAccountNumber) from Transaction where createDate=:transactionDate and fromAccountNumber=:accountNumber")
	List<transactionDto> findByAccountNumberAndTransactionDate1(long accountNumber, java.sql.Date transactionDate);

}
