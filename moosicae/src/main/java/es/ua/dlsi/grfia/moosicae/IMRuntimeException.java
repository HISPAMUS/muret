package es.ua.dlsi.grfia.moosicae;

/**
 *
 * @author drizo
 */
public class IMRuntimeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5986252837490028393L;

	public IMRuntimeException() {
	}

	public IMRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public IMRuntimeException(String message) {
		super(message);
	}

	public IMRuntimeException(Throwable cause) {
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
