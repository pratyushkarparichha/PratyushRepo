package com.nit.threads;

import com.nit.exceptions.InsufficentFundsException;
import com.nit.exceptions.InvalidAmountException;
import com.nit.pojo.BankAccount;

//public class WithdraweeThread implements Runnable {
public class WithdraweeThread extends Thread {
 	
	private BankAccount acc;
	private double amt;
	
	public WithdraweeThread(BankAccount acc, double amt) {
		this.acc = acc;
		this.amt = amt;
	}
	
	@Override
	public void run() {
		try {
			acc.withdraw(amt);
		} catch (InvalidAmountException|InsufficentFundsException e) {
			System.out.println("Error:"+e.getMessage());
		}
	}

}
