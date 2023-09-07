package com.nit.pojo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.nit.exceptions.InsufficentFundsException;
import com.nit.exceptions.InvalidAmountException;

public class BankAccount {
	
	private static String bankName;
	private static String branchName;
	private static String ifsc;
	
	private long accNum;
	private String accHName;
	private double balance;
	
	static {
		
	BufferedReader br = null;               //declaring BR variable
		try { //Connecting to file
			br = new BufferedReader(new FileReader("bankdetails.txt"));
												//initializing BR variable with object
			
		//Reading values from file and storing in static variable
			bankName = br.readLine();
			branchName = br.readLine();
			ifsc = br.readLine();
			
		} catch (FileNotFoundException e) {
		 System.out.println("Error: bankDetails.txt file is not found");
		} catch (IOException e) {
		  e.printStackTrace();
	
		}	
	} // static block end
	
	public BankAccount (long accNum, String accHName, double balance) {
	     
		 this.accNum   = accNum;
		 this.accHName = accHName;
		 this.balance  = balance;

	 }// constructor close

	public static String getBankName() {
		return bankName;
	}

	public static String getBranchName() {
		return branchName;
	}

	public static String getIfsc() {
		return ifsc;
	}

	public long getAccNum() {
		return accNum;
	}

	public String getAccHName() {
		return accHName;
	}

	public double getBalance() {
		return balance;
	}

	public void deposit(double amt) throws InvalidAmountException {
	 
       if (amt <= 0)
    	   throw new InvalidAmountException("Do not pass -ve or 0 amount");
	    this.balance = this.balance+amt;
	    System.out.println(amt+" is deposited in "+this.accNum+" account ");
	}
	
	public void withdraw(double amt) throws InvalidAmountException, InsufficentFundsException {
		
		if(amt <= 0)
			throw new InvalidAmountException("Do not pass -ve or 0 amount");
		if(amt > balance)
			throw new InsufficentFundsException("insuffient funds");
		
		this.balance = this.balance-amt;
		System.out.println(amt+" is withdraw from "+this.accNum+" account ");
	}
	
@Override
   public String toString() {
	      return "BankAccount(bank Name="+bankName+",branch Name="+branchName+",ifsc="
                                         +ifsc+",accNum="+accNum+",accHName="+accHName+",balance="
			                             +balance+")";
   }

}//BankAccount class close
	
	

