package es.ua.dlsi.grfia.im4.core.io.antlr4;

import org.antlr.v4.runtime.ConsoleErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

import java.util.ArrayList;

/**
 *
 * @author drizo
 */
 public class ErrorListener extends ConsoleErrorListener {
	ArrayList<ParseError> errors = new ArrayList<>();
	
	@Override
	public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
	    super.syntaxError(recognizer, offendingSymbol, line, charPositionInLine, msg, e); 
	    errors.add(new ParseError(offendingSymbol, line, charPositionInLine, msg, e));
	}
	public int getNumberErrorsFound() {
	    return errors.size();
	}

	public ArrayList<ParseError> getErrors() {
	    return errors;
	}
	
	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    for (ParseError error : errors) {
			sb.append(error.toString());
			sb.append('\n');
	    }
	    return sb.toString();
	}
}
