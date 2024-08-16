package com.user.exception;

public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException()
	{
		super("Resourse not found on server");
	}
	
	public ResourceNotFoundException(String message)
	{
		super(message);
	}
}
