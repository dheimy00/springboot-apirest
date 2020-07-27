package br.com.builders.util;

public class ClienteNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClienteNotFoundException() {
	}

	public ClienteNotFoundException(String message) {
		super(message);
	}

	public ClienteNotFoundException(Throwable cause) {
		super(cause);
	}

	public ClienteNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ClienteNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
