package com.ekta.myapp.exception;

public class ProjException extends Exception {
	public ProjException(String message)
	{
		super(message);
	}
	
	public ProjException(String message, Throwable cause)
	{
		super(message,cause);
	}

}
