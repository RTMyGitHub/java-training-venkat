package com.eshop.dao;

public class DAOException extends Exception {
	
	public DAOException(String errorMessage, Throwable ex)
	{
		super(errorMessage, ex);
	}
}
