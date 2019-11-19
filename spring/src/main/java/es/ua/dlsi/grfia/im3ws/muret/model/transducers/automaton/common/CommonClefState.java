package es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.common;

import es.ua.dlsi.grfia.im3ws.muret.model.transducers.SemanticTransduction;
import es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.TransducerState;
import es.ua.dlsi.im3.core.IM3RuntimeException;
import es.ua.dlsi.im3.core.adt.dfa.State;
import es.ua.dlsi.im3.core.io.ImportException;
import es.ua.dlsi.im3.core.score.NotationType;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticSymbol;
import es.ua.dlsi.im3.omr.encoding.semantic.semanticsymbols.SemanticClef;

public abstract class CommonClefState extends TransducerState {
    NotationType notationType;
    public CommonClefState(int number, NotationType notationType) {
        super(number, "clef");
        this.notationType = notationType;
    }

    @Override
    public void onEnter(AgnosticSymbol token, State previousState, SemanticTransduction transduction) throws ImportException {
        if (!(token.getSymbol() instanceof es.ua.dlsi.im3.omr.encoding.agnostic.agnosticsymbols.Clef)) {
            // the automaton has an error
            throw new IM3RuntimeException("Expected a clef and found a " + token.getSymbol());
        }

        es.ua.dlsi.im3.omr.encoding.agnostic.agnosticsymbols.Clef symbol = (es.ua.dlsi.im3.omr.encoding.agnostic.agnosticsymbols.Clef) token.getSymbol();

        if (symbol.getClefNote() == null) {
            throw new IM3RuntimeException("Value of clef is null");
        }

        SemanticClef semanticClef = new SemanticClef(notationType, symbol.getClefNote(), token.getPositionInStaff().getLine());
        semanticClef.setAgnosticIDs(token.getId());
        transduction.add(semanticClef);
    }
}

