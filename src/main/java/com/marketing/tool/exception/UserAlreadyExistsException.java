package com.marketing.tool.exception;

public class UserAlreadyExistsException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -3974850585631103799L;

	public UserAlreadyExistsException(final String message) {
        super(message);
    }

}
