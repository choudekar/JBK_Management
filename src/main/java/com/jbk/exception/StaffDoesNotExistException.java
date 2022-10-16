package com.jbk.exception;

public class StaffDoesNotExistException extends RuntimeException{
	
	public StaffDoesNotExistException(String msg) {
		super(msg);
	}

}
