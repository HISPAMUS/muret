package es.ua.dlsi.grfia.moosicae.utils.antlr4;

import es.ua.dlsi.grfia.moosicae.IM4RuntimeException;

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
