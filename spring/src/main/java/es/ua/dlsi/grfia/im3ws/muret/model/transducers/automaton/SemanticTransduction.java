package es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton;

import es.ua.dlsi.im3.core.adt.dfa.Transduction;
import es.ua.dlsi.im3.omr.encoding.semantic.SemanticEncoding;
import es.ua.dlsi.im3.omr.encoding.semantic.SemanticSymbol;
import es.ua.dlsi.im3.omr.encoding.semantic.SemanticSymbolType;
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
        semanticEncoding.add(new SemanticSymbol(semanticSymbolType));
    }

    public SemanticEncoding getSemanticEncoding() {
        return semanticEncoding;
    }

    public SemanticSymbol getLastSymbol() {
        return semanticEncoding.getSymbols().get(semanticEncoding.getSymbols().size()-1);
    }
}
