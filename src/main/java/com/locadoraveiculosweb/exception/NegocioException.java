package com.locadoraveiculosweb.exception;

public class NegocioException extends Exception{
	private static final long serialVersionUID = 1L;

	public NegocioException(String message) {
		super(message);
	}
	
	public NegocioException() {
	}
}