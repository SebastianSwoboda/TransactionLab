package ch.bbc.uk223.transactions.error;

/**
 * Exception die geworfen wird, wenn eine Person aus beliebigen Gründen nicht
 * gelöscht werden kann
 * 
 */
public class RemovePersonException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RemovePersonException() {
		super();
	}

	public RemovePersonException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public RemovePersonException(String message, Throwable cause) {
		super(message, cause);
	}

	public RemovePersonException(String message) {
		super(message);
	}

	public RemovePersonException(Throwable cause) {
		super(cause);
	}

}
