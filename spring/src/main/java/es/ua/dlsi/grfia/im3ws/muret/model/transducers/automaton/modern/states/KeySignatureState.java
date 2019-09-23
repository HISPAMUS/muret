package es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.modern.states;


import es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.common.CommonKeySignatureState;
import es.ua.dlsi.im3.core.score.NotationType;

public class KeySignatureState extends CommonKeySignatureState {

    public KeySignatureState(int number) {
        super(number, NotationType.eModern);
    }
}
