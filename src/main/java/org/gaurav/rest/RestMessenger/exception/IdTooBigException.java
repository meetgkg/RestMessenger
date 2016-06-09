package org.gaurav.rest.RestMessenger.exception;

public class IdTooBigException extends RuntimeException{

	private static final long serialVersionUID = -8543821206664596453L;

	public IdTooBigException(String message){
		super(message);
	}

}
