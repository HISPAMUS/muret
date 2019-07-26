package es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.mensural.states;

import es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.SemanticTransduction;
import es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.TransducerState;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.adt.dfa.State;
import es.ua.dlsi.im3.core.adt.dfa.Transduction;
import es.ua.dlsi.im3.core.score.Custos;
import es.ua.dlsi.im3.core.score.ScientificPitch;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticSymbol;
import es.ua.dlsi.im3.omr.encoding.semantic.semanticsymbols.SemanticClef;
import es.ua.dlsi.im3.omr.encoding.semantic.semanticsymbols.SemanticCustos;

public class CustosState extends TransducerState {
    public CustosState(int number) {
        super(number, "custos");
    }

    @Override
    public void onEnter(AgnosticSymbol token, State previousState, SemanticTransduction transduction) throws IM3Exception {
        SemanticClef clef = NotesState.findLastClef(transduction);

        ScientificPitch scientificPitch = NotesState.parsePitch(clef, token.getPositionInStaff(), null); //TODO accidental??

        Custos custos = new Custos(scientificPitch);
        SemanticCustos semanticCustos = new SemanticCustos(custos);
        transduction.add(semanticCustos);
    }
}

