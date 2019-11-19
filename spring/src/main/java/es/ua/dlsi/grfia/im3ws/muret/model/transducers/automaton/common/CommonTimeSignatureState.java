package es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.common;

import es.ua.dlsi.grfia.im3ws.muret.model.transducers.SemanticTransduction;
import es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.TransducerState;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.IM3RuntimeException;
import es.ua.dlsi.im3.core.adt.dfa.State;
import es.ua.dlsi.im3.core.score.NotationType;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticSymbol;
import es.ua.dlsi.im3.omr.encoding.agnostic.agnosticsymbols.MeterSign;
import es.ua.dlsi.im3.omr.encoding.enums.MeterSigns;
import es.ua.dlsi.im3.omr.encoding.semantic.semanticsymbols.SemanticMeterSignTimeSignature;

public class CommonTimeSignatureState extends TransducerState {
    NotationType notationType;
    public CommonTimeSignatureState(int number, NotationType notationType) {
        super(number, "keySig");
        this.notationType = notationType;
    }
    MeterSigns meterSigns;
    Long agnosticID;

    @Override
    public void onEnter(AgnosticSymbol token, State previousState, SemanticTransduction transduction) {
        if (!(token.getSymbol() instanceof MeterSign)) {
            // the automaton has an error
            throw new IM3RuntimeException("Expected a metersign and found a " + token.getSymbol());
        }

        MeterSign symbol = (MeterSign) token.getSymbol();
        meterSigns = symbol.getMeterSigns();
        agnosticID = token.getId();
        // TODO: 5/10/17 C3 escrito como C 3 ... Quizás habrá que hacer varios estados del autómata
        // TODO 2/4, ...
    }

    @Override
    public void onExit(State nextState, boolean isStateChange, SemanticTransduction transduction) throws IM3Exception {
        if (meterSigns == null) {
            throw new IM3RuntimeException("Meter signs cannot be null");
        }
        SemanticMeterSignTimeSignature meterSignTimeSignature = new SemanticMeterSignTimeSignature(notationType, meterSigns);
        meterSignTimeSignature.setAgnosticIDs(agnosticID);
        transduction.add(meterSignTimeSignature);
    }
}
