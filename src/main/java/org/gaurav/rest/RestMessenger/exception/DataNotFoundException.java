package org.gaurav.rest.RestMessenger.exception;

public class DataNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7064922640896661654L;

	public DataNotFoundException(String message){
		super(message);
	}

}
