package ch.bbc.uk223.transactions.error;

/**
 * Exception die geworfen wird, wenn eine Person aus beliebigen Gründen nicht
 * gespeichert werden kann
 * 
 */
public class SavePersonException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SavePersonException() {
		super();
	}

	public SavePersonException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public SavePersonException(String message, Throwable cause) {
		super(message, cause);
	}

	public SavePersonException(String message) {
		super(message);
	}

	public SavePersonException(Throwable cause) {
		super(cause);
	}

}
