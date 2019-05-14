package es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.mensural.states;

import es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.SemanticTransduction;
import es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.TransducerState;
import es.ua.dlsi.im3.core.IM3RuntimeException;
import es.ua.dlsi.im3.core.adt.dfa.State;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticSymbol;
import es.ua.dlsi.im3.omr.encoding.semantic.semanticsymbols.Clef;

public class ClefState extends TransducerState {
    public ClefState(int number) {
        super(number, "clef");
    }

    @Override
    public void onEnter(AgnosticSymbol token, State previousState, SemanticTransduction transduction)  {
        if (!(token.getSymbol() instanceof es.ua.dlsi.im3.omr.encoding.agnostic.agnosticsymbols.Clef)) {
            // the automaton has an error
            throw new IM3RuntimeException("Expected an clef and found a " + token.getSymbol());
        }

        es.ua.dlsi.im3.omr.encoding.agnostic.agnosticsymbols.Clef symbol = (es.ua.dlsi.im3.omr.encoding.agnostic.agnosticsymbols.Clef) token.getSymbol();

        if (symbol.getClefNote() == null) {
            throw new IM3RuntimeException("Value of clef is null");
        }

        Clef semanticClef = new Clef(symbol.getClefNote(), token.getPositionInStaff().getLine());
        transduction.add(semanticClef);
    }
}

