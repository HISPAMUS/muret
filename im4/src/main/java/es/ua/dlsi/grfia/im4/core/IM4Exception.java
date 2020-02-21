/*
 * Created on 13-ene-2004
 */
package es.ua.dlsi.grfia.im4.core;

/**
 * @author david
 */
public class IM4Exception extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 *
	 * @param msg
	 */
	public IM4Exception(String msg) {
		super(msg);
	}

	public IM4Exception(Exception e) {
		super(e);
	}

	public IM4Exception(Throwable cause) {
		super(cause);
	}

	public IM4Exception(String message, Throwable cause) {
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
