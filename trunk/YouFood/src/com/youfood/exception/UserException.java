package com.youfood.exception;

import java.util.logging.Logger;



public class UserException extends Exception {
	private Logger log = Logger.getLogger(UserException.class.getSimpleName());
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserException() {
		log.severe("A user exception occur -> " + this.getCause().getStackTrace().toString() );
	}

	public UserException(String message) {
		super(message);
		log.severe(message + " -> " + this.getCause().getStackTrace().toString());
	}

	public UserException(Throwable cause) {
		super(cause);		
		log.severe(cause.getMessage() + " -> " + cause.getStackTrace().toString());		
	}

	public UserException(String message, Throwable cause) {
		super(message, cause);
		log.severe(cause.getMessage() + " -> " + cause.getStackTrace().toString());
	}

}
