package es.ua.dlsi.grfia.im3ws.muret.model.transducers;

import es.ua.dlsi.im3.core.adt.dfa.Transduction;
import es.ua.dlsi.im3.omr.encoding.semantic.SemanticEncoding;
import es.ua.dlsi.im3.omr.encoding.semantic.SemanticSymbol;
import es.ua.dlsi.im3.omr.encoding.semantic.SemanticSymbolType;
import es.ua.dlsi.im3.omr.encoding.semantic.semanticsymbols.SemanticCompoundAtom;
import es.ua.dlsi.im3.omr.encoding.semantic.semanticsymbols.SemanticLigature;
import org.apache.commons.math3.fraction.BigFraction;

public class SemanticTransduction extends Transduction {
    SemanticEncoding semanticEncoding;

    public SemanticTransduction(BigFraction initialProbability) {
        super(initialProbability);
        this.semanticEncoding = new SemanticEncoding();
    }

    /*public void add(SemanticSymbol semanticSymbol) {
        semanticEncoding.add(semanticSymbol);
    }*/

    public void add(SemanticSymbolType semanticSymbolType) {
        semanticEncoding.add(semanticSymbolType);
        // semanticEncoding.add(new SemanticSymbol(semanticSymbolType));
    }

    public SemanticEncoding getSemanticEncoding() {
        return semanticEncoding;
    }

    public SemanticSymbol getLastSymbol() {
        return semanticEncoding.getSymbols().get(semanticEncoding.getSymbols().size()-1);
    }
}
