package com.market.demo.exception;

public class CustomerIdNotFoundException extends RuntimeException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomerIdNotFoundException(String message)
	{
		super(message);
	}
}
