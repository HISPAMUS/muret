package es.ua.dlsi.grfia.im4.core;

/**
 *
 * @author drizo
 */
public class IM4RuntimeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5986252837490028393L;

	public IM4RuntimeException() {
	}

	public IM4RuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public IM4RuntimeException(String message) {
		super(message);
	}

	public IM4RuntimeException(Throwable cause) {
		super(cause);
	}


	@Override
	public String getMessage() {
		if (this.getCause() != null) {
			return super.getMessage() + '\n' + this.getCause().getMessage();
		} else {
			return super.getMessage();
		}
	}
}
