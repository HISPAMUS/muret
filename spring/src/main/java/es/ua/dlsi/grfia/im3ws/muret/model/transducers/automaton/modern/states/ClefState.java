package es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.modern.states;

import es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.common.CommonClefState;
import es.ua.dlsi.im3.core.score.NotationType;

public class ClefState extends CommonClefState {
    public ClefState(int number) {
        super(number, NotationType.eModern);
    }
}

