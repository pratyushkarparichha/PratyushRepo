package com.nit.bank;

	import java.io.BufferedReader;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;

	public class BankAccount {
		private static String bankName;
		private static String branchName;
		private static String ifsc;
		
		private long accNum;
		private String accHName;
		private double balance;
		
		static {
			System.out.println("\n BankAccount class is loaded");
			try {Thread.sleep(1000);
			}catch (InterruptedException e) {}
			
			System.out.println("static variable memory alloctated with default values");
			try {Thread.sleep(1000);
			}catch (InterruptedException e) {}
			
			System.out.println("Reading static variable's value from file and intializing them");
			try {Thread.sleep(1000);
			}catch (InterruptedException e) {}
			
			BufferedReader fr = null;               //declaring BR variable
			try { //Connecting to file
				fr = new BufferedReader(new FileReader("bankdetails.txt"));
													//initializing BR variable with object
				
			//Reading values from file and storing in static variable
				bankName = fr.readLine();
				branchName = fr.readLine();
				ifsc = fr.readLine();
				
				System.out.println("static variable are intialized with file values \n");
				try {Thread.sleep(1000);
				}catch (InterruptedException e) {}
				
			} catch (FileNotFoundException e) {
			 System.out.println("Error: bankdetails.txt file is not found");
			} catch (IOException e) {
			  e.printStackTrace();
			}finally {
				if (fr != null) {      //condition for not getting nullPointer exception 
				try { fr.close();
				} catch (IOException e) {}
				}
			}
			try {Thread.sleep(1000);
			}catch (InterruptedException e) {}
			
		} // static block end
		
	//non-static block for initilizing accNum
		{
			System.out.println("Non-static variable memory allocated with default values");
			try {Thread.sleep(1000);
			}catch (InterruptedException e) {}
			
			System.out.println("Reading accNum value from file and intializing it");
			try {Thread.sleep(1000);
			}catch (InterruptedException e) {}
			
			BufferedReader fr = null;
			try { //connecting to file
			   fr = new BufferedReader(new FileReader("accNumSeq.txt"));
			   
			   //reading accNum, converting and storing
			   this.accNum = Long.parseLong(fr.readLine())+1;
			   
			   System.out.println("accNum is initialized with file value");
			   try {Thread.sleep(1000);
				}catch (InterruptedException e) {}
			}catch (FileNotFoundException e) {
				System.out.println("accNumSeq.txt file is not found");
			} catch (IOException e) {
				e.printStackTrace();
			}
		     finally {
		    	 if (fr != null);
		    	 try { fr.close();
		    	 } catch (IOException e) {}
		     }
			
	//saving new accNum in file
			FileWriter fw = null;
			
			try {
				fw = new FileWriter("accNumSeq.txt");
				
				fw.write(" "+this.accNum);   //writing data to FW object
				fw.flush();  //moving data from FW to file for saving permanently
			} catch (FileNotFoundException e) {
				System.out.println("accNumSeq.txt file is not found and unable to create");
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (fw != null) {
					try { fw.close();
						
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			
		} //non-static block is closed 
		
 //Constructor 
 public BankAccount (String accHName, double balance) {
	 
	 System.out.println("Other non-static variable are being initialized with given values");
	 try {Thread.sleep(1000);
		}catch (InterruptedException e) {}
	 
	 this.accHName = accHName;
	 this.balance = balance;
	 
	 System.out.println("non-static variable are being initialized with given object value");
	 try {Thread.sleep(1000);
		}catch (InterruptedException e) {}
	 
 }// constructor close

 //getter and setter 
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

public void setAccHName(String accHName) {
	this.accHName = accHName;
}

public double getBalance() {
	return balance;
}

public void setBalance(double balance) {
	this.balance = balance;
}

//methods 
public void withdraw(double amt) {
	this.balance = this.balance-amt;
}

public void deposit (double amt) {
	this.balance = balance + amt;
}

public void currentBalance() {
	System.out.println(balance);
}

@Override
public String toString() {
	return ("\n BankName \t:"+bankName) +"\n" +
           ("\n BranchName \t:"+branchName) +"\n"+
           ("\n ifsc \t:"+ifsc) +"\n"+
           ("\n AccNum \t:"+accNum) +"\n"+
           ("\n AccHName \t:"+accHName) +"\n"+
           ("\n Balance \t:"+balance);
}
           
			
	
} //class end
