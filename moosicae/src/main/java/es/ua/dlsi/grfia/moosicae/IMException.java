/*
 * Created on 13-ene-2004
 */
package es.ua.dlsi.grfia.moosicae;

/**
 * @author david
 */
public class IMException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 *
	 * @param msg
	 */
	public IMException(String msg) {
		super(msg);
	}

	public IMException(Exception e) {
		super(e);
	}

	public IMException(Throwable cause) {
		super(cause);
	}

	public IMException(String message, Throwable cause) {
		super(message, cause);
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
