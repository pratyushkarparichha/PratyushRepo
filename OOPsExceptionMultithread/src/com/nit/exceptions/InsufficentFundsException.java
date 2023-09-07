package com.nit.exceptions;

public class InsufficentFundsException extends Exception {

	//private static final long serialVersionUID = 1L;
	
	public InsufficentFundsException() {
		
	}
     
	public InsufficentFundsException(String msg) {
		super(msg);
	}
}
