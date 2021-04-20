package es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.common;

import es.ua.dlsi.grfia.im3ws.muret.model.transducers.SemanticTransduction;
import es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.TransducerState;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.IM3RuntimeException;
import es.ua.dlsi.im3.core.adt.dfa.State;
import es.ua.dlsi.im3.core.score.NotationType;
import es.ua.dlsi.im3.core.score.mensural.meters.ProportioDupla;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticSymbol;
import es.ua.dlsi.im3.omr.encoding.agnostic.agnosticsymbols.Digit;
import es.ua.dlsi.im3.omr.encoding.agnostic.agnosticsymbols.MeterSign;
import es.ua.dlsi.im3.omr.encoding.enums.MeterSigns;
import es.ua.dlsi.im3.omr.encoding.semantic.semanticsymbols.SemanticFractionalTimeSignature;
import es.ua.dlsi.im3.omr.encoding.semantic.semanticsymbols.SemanticMeterSignTimeSignature;
import es.ua.dlsi.im3.omr.encoding.semantic.semanticsymbols.SemanticProportioTimeSignature;

import java.util.ArrayList;
import java.util.List;

public class CommonTimeSignatureState extends TransducerState {
    NotationType notationType;
    MeterSigns meterSigns;
    List<AgnosticSymbol> digits;
    List<Long> agnosticIDs;

    public CommonTimeSignatureState(int number, NotationType notationType) {
        super(number, "timeSig");
        this.notationType = notationType;
        this.agnosticIDs = new ArrayList<>();
    }

    @Override
    public void onEnter(AgnosticSymbol token, State previousState, SemanticTransduction transduction) {
        agnosticIDs.add(token.getId());
        if (token.getSymbol() instanceof MeterSign) {
            MeterSign symbol = (MeterSign) token.getSymbol();
            meterSigns = symbol.getMeterSigns();
        } else if (token.getSymbol() instanceof Digit) {
            if (digits == null) {
                digits = new ArrayList<>();
            }
            digits.add(token);
        }

    }

    @Override
    public void onExit(State nextState, boolean isStateChange, SemanticTransduction transduction) throws IM3Exception {
        if (isStateChange) {
            // TODO: 5/10/17 C3 escrito como C 3 ... Quizás habrá que hacer varios estados del autómata
            if (meterSigns != null) {
                SemanticMeterSignTimeSignature meterSignTimeSignature = new SemanticMeterSignTimeSignature(notationType, meterSigns);
                meterSignTimeSignature.setAgnosticIDs(agnosticIDs);
                transduction.add(meterSignTimeSignature);
            } else if (digits != null && !digits.isEmpty()) {
                if (digits.size() == 1) {
                    Digit digit = (Digit) digits.get(0).getSymbol();
                    SemanticProportioTimeSignature semanticProportioTimeSignature;
                    if (notationType != NotationType.eMensural) {
                        throw new IM3Exception("Unsupported one digit time in modern notation");
                    }
                    if (digit.getDigit() == 2) {
                        semanticProportioTimeSignature = new SemanticProportioTimeSignature(NotationType.eMensural, 2);
                    } else if (digit.getDigit() == 3) {
                        semanticProportioTimeSignature = new SemanticProportioTimeSignature(NotationType.eMensural, 3);
                    } else {
                        throw new IM3Exception("Unsupported one digit time signature different of 2 or 3 in mensural, and found: " + digit.getDigit());
                    }
                    semanticProportioTimeSignature.setAgnosticIDs(agnosticIDs);
                    transduction.add(semanticProportioTimeSignature);
                } else if (digits.size() == 2) {
                    Digit numerator, denominator;
                    if (digits.get(0).getPositionInStaff().getLineSpace() > digits.get(1).getPositionInStaff().getLineSpace()) {
                        numerator = (Digit) digits.get(0).getSymbol();
                        denominator = (Digit) digits.get(1).getSymbol();
                    } else {
                        numerator = (Digit) digits.get(1).getSymbol();
                        denominator = (Digit) digits.get(0).getSymbol();
                    }
                    SemanticFractionalTimeSignature semanticFractionalTimeSignature = new SemanticFractionalTimeSignature(notationType, numerator.getDigit(), denominator.getDigit());
                    semanticFractionalTimeSignature.setAgnosticIDs(agnosticIDs);
                    transduction.add(semanticFractionalTimeSignature);
                } else {
                    throw new IM3Exception("Too many digits in time signature state: " + digits.size());
                }
            } else {
                throw new IM3Exception("No digits or meter signs in time signature state");
            }

            digits = null;
        }
    }
}
