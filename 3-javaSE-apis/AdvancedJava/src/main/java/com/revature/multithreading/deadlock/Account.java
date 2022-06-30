package com.revature.multithreading.deadlock;

public class Account {
	
	private int balance;
	private int transferCount;
	
	
	public void transfer(Account b, int amount) {
		
		// Check if the balance is valid
		if(this.getBalance()< amount)
			return;
		
		// Reduce account by amount
		this.setBalance(this.getBalance()-amount);
		
		// Increase the other account's value
		b.setBalance(b.getBalance() + amount);
		
		//Increment transfer count
		this.transferCount++;
	}
	
	
	
	
	
	
	// Generated Methods below
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getTransferCount() {
		return transferCount;
	}
	public void setTransferCount(int transferCount) {
		this.transferCount = transferCount;
	}
	public Account(int balance) {
		super();
		this.balance = balance;
	}
	public Account() {
		super();
	}
	@Override
	public String toString() {
		return "Account [balance=" + balance + ", transferCount=" + transferCount + "]";
	}
	
	
	

}
