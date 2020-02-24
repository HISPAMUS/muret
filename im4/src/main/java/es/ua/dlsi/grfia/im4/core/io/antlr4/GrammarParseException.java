package es.ua.dlsi.grfia.im4.core.io.antlr4;

import es.ua.dlsi.grfia.im4.core.IM4Exception;

import java.util.ArrayList;

/**
 *
 * @author drizo
 */
public class GrammarParseException extends IM4Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<ParseError> errors;

    public GrammarParseException(String errorMessage, ArrayList<ParseError> errors) {
		super(errorMessage);
		this.errors = errors;
    }
    
    public ArrayList<ParseError> getErrors() {
	return errors;
    }
    
}
