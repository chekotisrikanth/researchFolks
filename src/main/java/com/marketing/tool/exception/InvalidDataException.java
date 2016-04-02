package com.marketing.tool.exception;

public class InvalidDataException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -3974850585631103799L;

	public InvalidDataException(final String message) {
        super(message);
    }

}
