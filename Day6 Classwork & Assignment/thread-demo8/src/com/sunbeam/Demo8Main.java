package com.sunbeam;

class Account {
	private int id;
	private String type;
	private double balance;
	public Account() {
	}
	public Account(int id, String type, double balance) {
		this.id = id;
		this.type = type;
		this.balance = balance;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", type=" + type + ", balance=" + balance + "]";
	}
	public void deposit(double amount) {
		double newBalance = this.balance + amount;
		this.balance = newBalance;
	}
	public void withdraw(double amount) {
		double newBalance = this.balance - amount;
		this.balance = newBalance;
	}
}

public class Demo8Main {
	public static void main(String[] args) throws Exception {
		Account acc = new Account(101, "Saving", 100000);
		
		class DepositThread extends Thread {
			@Override
			public void run() {
				for (int i = 1; i <= 10000; i++) {
					acc.deposit(100);
					System.out.println("After Deposit: " + acc.getBalance());
				}
			}
		}
		Thread dt = new DepositThread();
		dt.start();
		
		class WithdrawThread extends Thread {
			@Override
			public void run() {
				for (int i = 1; i <= 10000; i++) {
					acc.withdraw(100);
					System.out.println("After Withdraw: " + acc.getBalance());
				}
			}
		}
		Thread wt = new WithdrawThread();
		wt.start();

		dt.join();
		wt.join();
		System.out.println("Final Balance: " + acc.getBalance());
	}
}





