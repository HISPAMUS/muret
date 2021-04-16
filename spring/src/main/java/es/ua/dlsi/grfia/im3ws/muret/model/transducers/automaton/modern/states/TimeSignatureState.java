package es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.modern.states;

import es.ua.dlsi.grfia.im3ws.muret.model.transducers.SemanticTransduction;
import es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.common.CommonTimeSignatureState;
import es.ua.dlsi.im3.core.adt.dfa.State;
import es.ua.dlsi.im3.core.score.NotationType;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticSymbol;

public class TimeSignatureState extends CommonTimeSignatureState {
    NotationType notationType;
    public TimeSignatureState(int number) {
        super(number,  NotationType.eModern);
    }

}
