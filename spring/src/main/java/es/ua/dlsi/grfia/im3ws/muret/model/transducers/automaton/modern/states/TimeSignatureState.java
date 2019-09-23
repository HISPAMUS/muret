package es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.modern.states;

import es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.common.CommonTimeSignatureState;
import es.ua.dlsi.im3.core.score.NotationType;

public class TimeSignatureState extends CommonTimeSignatureState {
    NotationType notationType;
    public TimeSignatureState(int number) {
        super(number,  NotationType.eModern);
    }
}
