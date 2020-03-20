package es.ua.dlsi.grfia.moosicae.utils.antlr4;

import es.ua.dlsi.grfia.moosicae.IMRuntimeException;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class GrammarParseRuntimeException extends IMRuntimeException {

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
