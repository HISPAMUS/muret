package es.ua.dlsi.grfia.moosicae.io.kern;

import es.ua.dlsi.grfia.moosicae.IMException;
import es.ua.dlsi.grfia.moosicae.core.IMooObject;
import es.ua.dlsi.grfia.moosicae.core.IVoicedItem;
import es.ua.dlsi.grfia.moosicae.io.kern.grammar.KernDocument;
import es.ua.dlsi.grfia.moosicae.io.kern.grammar.KernToken;
import es.ua.dlsi.grfia.moosicae.io.kern.grammar.tokens.KernCoreSymbol;

/**
 * @author David Rizo - drizo@dlsi.ua.es
 * @created 16/03/2020
 */
public class KernExporterVisitorTokenParam {
    private final KernDocument document;
    private KernToken previousToken;
    private StringBuilder stringBuilder;
    private BeamGroupExportState beamGroupState; //TODO Modify for spines

    public KernExporterVisitorTokenParam(KernDocument document, KernToken previousToken) {
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

    public KernToken getLastToken() {
        return previousToken;
    }

    public void buildAndAddToken(IMooObject symbol) throws IMException {
        KernCoreSymbol newToken = new KernCoreSymbol(stringBuilder.toString(), symbol);
        this.document.add(previousToken, newToken);
        previousToken = newToken; // it allows us to add new tokens after this one
        this.stringBuilder = new StringBuilder(); // reset for new one
    }

    public BeamGroupExportState getBeamGroupState() {
        return beamGroupState;
    }

    public void setBeamGroupState(BeamGroupExportState beamGroupState) {
        this.beamGroupState = beamGroupState;
    }
}
