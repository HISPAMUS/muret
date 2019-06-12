package es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.mensural.states;

import es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.SemanticTransduction;
import es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.TransducerState;
import es.ua.dlsi.im3.core.adt.dfa.State;
import es.ua.dlsi.im3.core.adt.dfa.Transduction;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticSymbol;

public class CustosState extends TransducerState {
    public CustosState(int number) {
        super(number, "custos");
    }

    @Override
    public void onEnter(AgnosticSymbol token, State previousState, SemanticTransduction transduction)  {
        /*if (!(token.getSymbol() instanceof es.ua.dlsi.im3.omr.encoding.agnostic.agnosticsymbols.Clef)) {
            // the automaton has an error
            throw new IM3RuntimeException("Expected an clef and found a " + token.getSymbol());
        }

        es.ua.dlsi.im3.omr.encoding.agnostic.agnosticsymbols.Clef symbol = (es.ua.dlsi.im3.omr.encoding.agnostic.agnosticsymbols.Clef) token.getSymbol();

        if (symbol.getClefNote() == null) {
            throw new IM3RuntimeException("Value of clef is null");
        }

        // TODO: 3/10/17 NotationType
        es.ua.dlsi.im3.core.score.Clef clef = null; // TODO: 3/10/17 Octave change
        try {
            clef = ImportFactories.createClef(transduction.getStaff().getNotationResponseType(), symbol.getClefNote().name(), token.getPositionInStaff().getLine(), 0);
        } catch (ImportException e) {
            transduction.setZeroProbability();
        }

        // TODO: 3/10/17 Cálculo de la probabilidad - ej. que para G2 esté en la línea 5

        try {
            transduction.getStaff().addClef(clef);

        } catch (IM3Exception e) {
            throw new IM3RuntimeException(e);
        }*/
    }
}

