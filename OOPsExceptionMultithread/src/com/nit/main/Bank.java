package com.nit.main;

import com.nit.pojo.BankAccount;
import com.nit.threads.DepositorThread;
import com.nit.threads.WithdraweeThread;

public class Bank {

	public static void main(String[] args) throws InterruptedException{
		
		System.out.println("BANK OPEN");
		BankAccount acc1 = new BankAccount(1234,"HK",1000);
		BankAccount acc2 = new BankAccount(1235,"BK",2000);
		BankAccount acc3 = new BankAccount(1236,"PK",3000);
		
		System.out.println(acc1); System.out.println(acc2); System.out.println(acc3);
		
		System.out.println("\n acc1 balance:"+acc1.getBalance());
		System.out.println("\n acc2 balance:"+acc2.getBalance());
		System.out.println("\n acc3 balance:"+acc3.getBalance());
		
		//new Thread(new DepositorThread(acc1, 5000)).start();
		//new Thread(new DepositorThread(acc2, 3000)).start();
		//new Thread(new DepositorThread(acc3, 5000)).start();
		
		new DepositorThread(acc1, 5000).start();
		new DepositorThread(acc2, 3000).start();
		new WithdraweeThread(acc3, 2000).start();
		
		Thread.sleep(1000);
		System.out.println("\n acc1 balance:"+acc1.getBalance());
		System.out.println("\n acc2 balance:"+acc2.getBalance());
		System.out.println("\n acc3 balance:"+acc3.getBalance());
		System.out.println();
		
		System.out.println("BANK CLOSE");
	}

}
