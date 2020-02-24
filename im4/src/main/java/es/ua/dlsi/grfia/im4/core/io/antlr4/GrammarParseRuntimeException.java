package es.ua.dlsi.grfia.im4.core.io.antlr4;

import es.ua.dlsi.grfia.im4.core.IM4RuntimeException;

/**
 *
 * @author drizo
 */
public class GrammarParseRuntimeException extends IM4RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GrammarParseRuntimeException(String message) {
	super(message);
    }

    public GrammarParseRuntimeException(Throwable cause) {
	super(cause);
    }
}
