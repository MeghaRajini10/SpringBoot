package com.example.demo.dto;

public class transactionDto {
	private long account;

	public long getAccount() {
		return account;
	}

	public void setAccount(long account) {
		this.account = account;
	}

	private double amount;
	private String status;

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public transactionDto(double amount, long account) {
		super();
		this.amount = amount;
		this.account = account;
	}

}
