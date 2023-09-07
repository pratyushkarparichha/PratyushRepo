package com.nit.exceptions;

public class InvalidAmountException extends Exception {

	//private static final long serialVersionUID = 1L;
	public InvalidAmountException() {
		
	}
	
	public InvalidAmountException(String msg) {
		super(msg);
	}
}
