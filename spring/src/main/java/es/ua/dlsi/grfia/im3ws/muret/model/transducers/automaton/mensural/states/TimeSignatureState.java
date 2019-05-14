package es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.mensural.states;

import es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.SemanticTransduction;
import es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.TransducerState;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.IM3RuntimeException;
import es.ua.dlsi.im3.core.adt.dfa.State;
import es.ua.dlsi.im3.core.score.NotationType;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticSymbol;
import es.ua.dlsi.im3.omr.encoding.agnostic.agnosticsymbols.MeterSign;
import es.ua.dlsi.im3.omr.encoding.enums.MeterSigns;
import es.ua.dlsi.im3.omr.encoding.semantic.semanticsymbols.MeterSignTimeSignature;

public class TimeSignatureState extends TransducerState {
    public TimeSignatureState(int number) {
        super(number, "keySig");
    }
    MeterSigns meterSigns;

    @Override
    public void onEnter(AgnosticSymbol token, State previousState, SemanticTransduction transduction) {
        if (!(token.getSymbol() instanceof MeterSign)) {
            // the automaton has an error
            throw new IM3RuntimeException("Expected a metersign and found a " + token.getSymbol());
        }

        MeterSign symbol = (MeterSign) token.getSymbol();
        meterSigns = symbol.getMeterSigns();
        // TODO: 5/10/17 C3 escrito como C 3 ... Quizás habrá que hacer varios estados del autómata
    }

    @Override
    public void onExit(State nextState, boolean isStateChange, SemanticTransduction transduction) {
        if (meterSigns == null) {
            throw new IM3RuntimeException("Meter signs cannot be null");
        }
        MeterSignTimeSignature meterSignTimeSignature = new MeterSignTimeSignature(meterSigns);
        transduction.add(meterSignTimeSignature);
    }
}
