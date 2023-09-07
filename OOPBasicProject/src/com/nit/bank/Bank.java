package com.nit.bank;

import java.util.Scanner;

public class Bank {
	
	private BankAccount[] accounts;
	private int size;
	private Scanner scanner;
	
	//constructor
	public Bank() {
		accounts = new BankAccount[10];
		size = 0;
		scanner = new Scanner(System.in);
	}
	
	//methods
	private void pause() {
		try { Thread.sleep(1000);
		} catch (InterruptedException e) {}
	}
	
	public void openAccount() {
		System.out.println("Enter Account Houlder Name::");
		String accHName = scanner.nextLine();
		
		System.out.println("Enter Balance::");
		double balance = scanner.nextDouble(); scanner.nextLine();
		
		System.out.println("BankAccount object creation started....");
		pause();
		
		BankAccount account = new BankAccount(accHName, balance);
		System.out.println("BankAccount object is created");
		pause();
		
		accounts[size++] = account;
		System.out.println("BankAccount object is stored in bank");
		pause();
		
	}//open Account() method close
	
	private BankAccount getAccount(long accNum) throws IllegalArgumentException {
		if (accNum <=0)
			throw new IllegalArgumentException("Account number can not be -ve number or zero");
		
		System.out.println("Searching for given account number object");
		pause();
		
		//Linear search algorithum
		for (int i=0; i<size; i++) {
			BankAccount account = accounts[i];
			 if (account.getAccNum() == accNum);
			 return account;
		}
		return null;
	}
	
	public void deposit(long accNum, double amt) throws IllegalArgumentException {
		
		System.out.println("deposit operation start");
		pause();
		
		if (amt <= 0)
			throw new IllegalArgumentException("Amount can not be -ve or zero");
		
		//retrieving the BankAccount object of the given account number
		BankAccount account = getAccount(accNum);
		
		//checking account and balance valid or not
		if (account == null)
			throw new IllegalArgumentException("Account is not found with the given details");
		
		//depositing given amount in the given account
		account.deposit(amt);
		System.out.println("Cah Rs"+amt+"is credited to your account");
		pause();
		
	}//deposit close
	
	public void withdraw(long accNum, double amt) throws IllegalArgumentException {
		
		System.out.println("withdraw operation start...");
		pause();
		
		//retriving the BankAccount object of the given account number
		BankAccount account = getAccount(accNum);
		
		//checking account and balnce valid or not
		if (account == null)
			throw new IllegalArgumentException("Account is not found with the given details");
		
		if(amt <= 0)
			throw new IllegalArgumentException("Amount can not be -ve or zero");
		
		if(amt > account.getBalance())
			throw new IllegalArgumentException("Insufficient funds");
		
		account.withdraw(amt);
		System.out.println("Cash Rs"+amt+"is debited from your account");
		pause();
	}// withdraw close
	
	public void balanceEnquiry(long accNum) throws IllegalArgumentException {
		System.out.println("balance enquiry operation start...");
		pause();
		
		//retriving the BankAccount object of the given account number
		BankAccount account = getAccount(accNum);
		
		//checking account valid or not
		if (account == null)
			throw new IllegalArgumentException("Account is not found with the given details");
		System.out.println("Current Balance::");
		account.currentBalance();
	}//balanceenquiry close
	
	public void transferAmount(long sourceAccNum, long destinationAccNum, double amt)
	                                                              throws IllegalArgumentException {
		
		System.out.println("transfer money opertaion start...");
		pause();
		
		withdraw(sourceAccNum, amt);
		deposit(destinationAccNum, amt);
		
		System.out.println("transfer money operation end");
		pause();
	}//transferamount close
	
	public void closeAccount(long accNum) throws IllegalArgumentException {
		System.out.println("closeaccount start..");
		pause();
		
		
		if (accNum <= 0)
			throw new IllegalArgumentException("Account can not be -ve or zero");
		
		System.out.println("Searching for given account number object");
		pause();
		
		//linear searching algorithm
		for (int i=0; i<size; i++) { //for finding BankAccount object for the given account
			BankAccount account = accounts[i];
			
			if(account.getAccNum()==accNum) {
				for(int j=i; j<size-1; j++) {
					accounts[j] = accounts[j+1];
					//removing current location object by moving next object one location left
					accounts[size-1] = null;
					size--;
					//removing reference from last location, and decreasing size by one
					
					System.out.println("account is deleted");
					pause();
					return; //success close, terminating method execution 
					        //the account object is deleted, 
					        //no need to execute this method logic further
				}
			}
		}//for loop closed
			throw new IllegalArgumentException("Account is not found with the given details");
	}// close account() end
		
 
 public void displayAccount(long accNum) throws IllegalArgumentException {
	 
	 System.out.println("displayAccount operation start..");
	 pause();
	 
	 //retrieving the BankAccount object of the given account number
	 BankAccount account = getAccount(accNum);
	 
	 //checking account and balance valid or not
	 if(account == null)
		 throw new IllegalArgumentException ("Account not found with the given details ");
	 
	 System.out.println("Account details::");
	 
	 System.out.println(account);//internally call account.toString()
	                        //it is executed from BankAccount class, this account object state(values)
                           //is return to print(), further println() display those details
 }
 
 @Override
 public String toString() {
	 if (size == 0)
		 return "No account found";
	 
	 StringBuilder accountsBuilder = new StringBuilder();
	 for (int i=0; i<size;i++) {
		 accountsBuilder.append("\n account"+(i+1)+"details");
		 accountsBuilder.append(accounts[i]+"\n");
		                          //internally toString() is called as accounts[i].toString()
	 }
	 return accountsBuilder.toString(); //converting StringBuilder object to string object
 }  
	
	
}//Bank Class close
	
	
		
		
	
	
	
	
	
	
	
