package uk.gomedia.exceptions;


public class UserException extends Exception{
	private static final long serialVersionUID = 12L;
	
	public UserException(String message){
		super(message);
	}
}
