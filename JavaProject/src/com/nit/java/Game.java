package com.nit.java;

import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int myNumber = (int)(Math.random()*100);
		int userNumber;
		
	  do {
		  System.out.println("Guess My Number::");
		  userNumber = sc.nextInt();
		  
		  if (userNumber == myNumber) {
			  System.out.println("Wooohoo you guessed it right");
			  break;
		  }
		      else if (userNumber > myNumber) 
		    	  System.out.println("Your Number is Too Big");
		      else 
		    	  System.out.println("Your Number is Too Small");
	  } while(userNumber >= 0);
		  System.out.println("My Number is::"+myNumber);

	}

}
