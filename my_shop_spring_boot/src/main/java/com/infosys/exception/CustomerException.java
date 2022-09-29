package com.infosys.exception;

public class CustomerException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 6752307295690970142L;

	public CustomerException(String message) {
    	super(message); // Parent class constructor is invoked.
    	// Here the parent class is Exception
    }
}
