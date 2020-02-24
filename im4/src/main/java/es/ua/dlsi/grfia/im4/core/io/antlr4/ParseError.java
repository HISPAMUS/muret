package es.ua.dlsi.grfia.im4.core.io.antlr4;

import org.antlr.v4.runtime.RecognitionException;

/**
 *
 * @author drizo
 */
public class ParseError {
    Object offendingSymbol;
    int line;
    int charPositionInLine;
    String msg;
    RecognitionException exception;
    public ParseError(Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException exception) {
	this.offendingSymbol = offendingSymbol;
	this.line = line;
	this.charPositionInLine = charPositionInLine;
	this.msg = msg;
	this.exception = exception;
    }

    @Override
    public String toString() {
	return "(" + line + ", " + charPositionInLine + "):" + this.msg;
    }

    public Object getOffendingSymbol() {
	return offendingSymbol;
    }

    public int getLine() {
	return line;
    }

    public int getCharPositionInLine() {
	return charPositionInLine;
    }

    public String getMsg() {
	return msg;
    }
    
}
