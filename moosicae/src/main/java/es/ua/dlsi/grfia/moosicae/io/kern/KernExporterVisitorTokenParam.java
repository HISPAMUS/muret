package es.ua.dlsi.grfia.moosicae.io.kern;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IMooObject;
import es.ua.dlsi.grfia.moosicae.core.ITuplet;
import es.ua.dlsi.grfia.moosicae.io.kern.grammar.KernDocument;
import es.ua.dlsi.grfia.moosicae.io.kern.grammar.KernToken;
import es.ua.dlsi.grfia.moosicae.io.kern.grammar.tokens.KernCoreSymbol;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 16/03/2020
 */
public class KernExporterVisitorTokenParam {
    private final KernDocument document;
    private final KernExporterContext kernExporterContext;
    private KernToken previousToken;
    private StringBuilder stringBuilder;
    private ITuplet inTuplet;

    public KernExporterVisitorTokenParam(KernDocument document, KernExporterContext kernExporterContext, KernToken previousToken) {
        this.document = document;
        this.previousToken = previousToken;
        this.stringBuilder = new StringBuilder();
        this.kernExporterContext = kernExporterContext;
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

    public KernToken getLastToken() {
        return previousToken;
    }

    public KernExporterContext getKernExporterContext() {
        return kernExporterContext;
    }

    public ITuplet getInTuplet() {
        return inTuplet;
    }

    public void setInTuplet(ITuplet inTuplet) {
        this.inTuplet = inTuplet;
    }

    public void buildAndAddToken(IMooObject symbol) throws IMException {
        KernCoreSymbol newToken = new KernCoreSymbol(stringBuilder.toString(), symbol);
        this.document.add(previousToken, newToken);
        previousToken = newToken; // it allows us to add new tokens after this one
        this.stringBuilder = new StringBuilder(); // reset for new one
    }

}
