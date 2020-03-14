package es.ua.dlsi.grfia.moosicae.utils.antlr4;

import es.ua.dlsi.grfia.moosicae.IMException;

import java.util.ArrayList;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 */
public class GrammarParseException extends IMException {
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
