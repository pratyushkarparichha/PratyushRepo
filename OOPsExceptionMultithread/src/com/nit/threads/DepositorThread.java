package com.nit.threads;

import com.nit.exceptions.InvalidAmountException;
import com.nit.pojo.BankAccount;

//public class DepositorThread implements Runnable {
public class DepositorThread extends Thread {
	
	private BankAccount acc;
	private double amt;

	public DepositorThread(BankAccount acc, double amt) {
		this.acc = acc;
		this.amt = amt;
	}
		@Override
		public void run() {
			try {
				acc.deposit(amt);
			} catch (InvalidAmountException e) {
				System.out.println("Error:"+e.getMessage());
			}
		}
}
	