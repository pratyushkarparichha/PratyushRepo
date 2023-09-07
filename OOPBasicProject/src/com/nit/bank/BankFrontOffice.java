package com.nit.bank;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankFrontOffice {

	public static void main(String[] args) {
		
		Bank hdfcBank = new Bank();
		Scanner scn = new Scanner(System.in);
		
	loop:  while(true) {
		 try {
			 System.out.println("\n Choose One Option");
			 System.out.println("1. Open Account");
			 System.out.println("2. Account Details");
			 System.out.println("3. Deposit");
			 System.out.println("4. Withdraw");
			 System.out.println("5. Balance Enquiry");
			 System.out.println("6. Transfer Money");
			 System.out.println("7. Display All Accounts");
			 System.out.println("8. Exit");
			 
			 System.out.println("ENTER OPTION::");
			 int option = scn.nextInt();scn.nextLine();
			 
		switch (option) {
		case 1 : {//open account
			hdfcBank.openAccount();
			break;
		}
		
		case 2 : {//account details
			System.out.println("Enter Account Number::");
			long accNum = scn.nextLong();scn.nextLine();
			hdfcBank.displayAccount(accNum);
			break;
		}
		
		case 3 : {//deposit
			System.out.println("Enter Account Number::");
			long accNum = scn.nextLong(); scn.nextLine();
			
			System.out.println("Enter Deposit Amount:");
			double amt = scn.nextDouble(); scn.nextLine();
			
			hdfcBank.deposit(accNum, amt);
			break;
		}
		
		case 4 : {//withdraw
			System.out.println("Enter account number:");
			long accNum = scn.nextLong(); scn.nextLine();
			
			System.out.println("Enter Withdraw Amount:");
			double amt = scn.nextDouble(); scn.nextLine();
			
			hdfcBank.withdraw(accNum, amt);
			break;
		}
		
		case 5 : { //Balance Enquiry
			System.out.println("Enter Account number:");
			long accNum = scn.nextLong(); scn.nextLine();
			
			hdfcBank.balanceEnquiry(accNum);
			break;
		}
		
		case 6 : {// transfer amount
			System.out.println("Enter source account number:");
			long srcAccNum = scn.nextLong(); scn.nextLine();
			
			System.out.println("Enter Destination number:");
			long destAccNum = scn.nextLong(); scn.nextLine();
			
			System.out.println("Enter deposit amount:");
			double amt = scn.nextDouble(); scn.nextLine();
			
			hdfcBank.transferAmount(srcAccNum, destAccNum, amt);
			break;
		}
		
		case 7 : {//display all accounts
			System.out.println(hdfcBank);
			break;
		}
		
		case 8 : {//exit
			System.out.println("_/\\_/\\_/\\_/\\_/\\Thank You_/\\_/\\_/\\_/\\_/\\");
			System.out.println("Please Visit Again");
			
			break loop;
		}
		default : {
			System.out.println("Invalid Option");
		}
		
		}//switch end

		 } catch (IllegalArgumentException e) {
			 System.out.println("Error:"+ e.getMessage());
		 } catch (InputMismatchException ie) {
			 System.out.println("Error:" + ie.getMessage());
			 scn.nextLine();
		 }
	  }//while (true) end
			 
	}
}
