package es.ua.dlsi.grfia.moosicae.io.skm;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IVoicedSingle;
import es.ua.dlsi.grfia.moosicae.io.skm.grammar.SkmDocument;
import es.ua.dlsi.grfia.moosicae.io.skm.grammar.SkmToken;
import es.ua.dlsi.grfia.moosicae.io.skm.grammar.tokens.SkmCoreSymbol;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 16/03/2020
 */
public class SkmExporterVisitorTokenParam {
    private final SkmDocument document;
    private SkmToken previousToken;
    private StringBuilder stringBuilder;

    public SkmExporterVisitorTokenParam(SkmDocument document, SkmToken previousToken) {
        this.document = document;
        this.previousToken = previousToken;
        this.stringBuilder = new StringBuilder();
    }

    public void append(String subtoken) {
        stringBuilder.append(subtoken);
    }

    public void append(int subtoken) {
        stringBuilder.append(subtoken);
    }

    public void append(char subtoken) {
        stringBuilder.append(subtoken);
    }

    public SkmToken getLastToken() {
        return previousToken;
    }

    public void buildAndAddToken(IVoicedSingle symbol) throws IMException {
        SkmCoreSymbol newToken = new SkmCoreSymbol(stringBuilder.toString(), symbol);
        this.document.add(previousToken, newToken);
        previousToken = newToken; // it allows us to add new tokens after this one
        this.stringBuilder = new StringBuilder(); // reset for new one
    }


}
