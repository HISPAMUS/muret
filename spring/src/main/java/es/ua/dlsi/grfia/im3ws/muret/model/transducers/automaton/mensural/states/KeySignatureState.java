package es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.mensural.states;

import es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.SemanticTransduction;
import es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.TransducerState;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.IM3RuntimeException;
import es.ua.dlsi.im3.core.adt.dfa.State;
import es.ua.dlsi.im3.core.adt.dfa.Transduction;
import es.ua.dlsi.im3.core.score.*;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticSymbol;
import es.ua.dlsi.im3.omr.encoding.agnostic.agnosticsymbols.Accidental;
import es.ua.dlsi.im3.omr.language.OMRTransduction;
import es.ua.dlsi.im3.omr.language.mensural.states.OMRState;

import java.util.ArrayList;

public class KeySignatureState extends TransducerState {
    ArrayList<PositionInStaff> positions;
    ArrayList<Accidentals> accidentals;

    public KeySignatureState(int number) {
        super(number, "keySig");
    }

    @Override
    public void onEnter(AgnosticSymbol token, State previousState, SemanticTransduction transduction) {
        if (!(token.getSymbol() instanceof Accidental)) {
            // the automaton has an error
            throw new IM3RuntimeException("Expected an accidental and found a " + token.getSymbol());
        }
        Accidental symbol = (Accidental) token.getSymbol();

        if (accidentals == null) {
            accidentals = new ArrayList<>();
            positions = new ArrayList<>();
        }

        es.ua.dlsi.im3.omr.encoding.agnostic.agnosticsymbols.Accidentals value = symbol.getAccidentals();
        if (value == null) {
            throw new IM3RuntimeException("Value of accidental is null");
        }
        //System.out.println(token.getValue());
        switch (value) {
            case flat:
                accidentals.add(Accidentals.FLAT);
                break;
            case sharp:
                accidentals.add(Accidentals.SHARP);
                break;
            default:
                // TODO: 4/10/17 Modern key signatures or key signature change may contain naturals
                transduction.setZeroProbability();
                //throw new IM3Exception("Cannot generate use this accidental in a key signature: " + token.getValue());
        }
        positions.add(token.getPositionInStaff());
    }

    @Override
    public void onExit(State nextState, boolean isStateChange, SemanticTransduction transduction) {
       /* if (accidentals == null) {
            // If no accidental has been found no key signature is indicated in the score
            // Not to be confused with the presence of a CM or Am key
            throw new IM3RuntimeException("Cannot generate a key signature without keys");
        }

        if (isStateChange) {
            Key key = null;
            // TODO: 5/10/17 Detectar si el doble bemol es la misma nota
            // TODO: 5/10/17 Comprobar las armaduras usuales
            try {
                if (accidentals.get(0) == Accidentals.FLAT) {
                    key = new Key(-accidentals.size(), Mode.UNKNOWN);
                } else {
                    key = new Key(accidentals.size(), Mode.UNKNOWN);
                }
                transduction.getStaff().addKeySignature(new KeySignature(transduction.getStaff().getNotationResponseType(), key));
            } catch (IM3Exception e) {
                throw new IM3RuntimeException(e);
            }

            positions = null;
            accidentals = null;
        }*/
    }
}
