package es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.common;

import es.ua.dlsi.grfia.im3ws.muret.model.transducers.SemanticTransduction;
import es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.TransducerState;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.IM3RuntimeException;
import es.ua.dlsi.im3.core.adt.dfa.State;
import es.ua.dlsi.im3.core.score.Accidentals;
import es.ua.dlsi.im3.core.score.DiatonicPitch;
import es.ua.dlsi.im3.core.score.ScientificPitch;
import es.ua.dlsi.im3.core.score.Staff;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticSymbol;
import es.ua.dlsi.im3.omr.encoding.semantic.semanticsymbols.SemanticClef;

import java.util.ArrayList;
import java.util.List;

public class AccNoteState extends TransducerState {
    private Accidentals accidental;

    private Long agnosticID;

    public AccNoteState(int number) {
        super(number, "accnote");
    }

    @Override
    public void onEnter(AgnosticSymbol token, State previousState, SemanticTransduction transduction) throws IM3Exception {
        agnosticID = token.getId();

        if (!(token.getSymbol() instanceof es.ua.dlsi.im3.omr.encoding.agnostic.agnosticsymbols.Accidental)) {
            // the automaton has an error
            throw new IM3RuntimeException("Expected an accidental and found a " + token.getSymbol());
        }
        es.ua.dlsi.im3.omr.encoding.agnostic.agnosticsymbols.Accidental symbol = (es.ua.dlsi.im3.omr.encoding.agnostic.agnosticsymbols.Accidental) token.getSymbol();

        if (symbol.getAccidentals() == null) {
            throw new IM3RuntimeException("Token value cannot be null");
        }
        // TODO: 2/3/18 Alteraciones que anulen las anteriores
        switch (symbol.getAccidentals()) {
            case flat: // double flats are encoded as two symbols
                accidental = Accidentals.FLAT;
                break;
            case sharp:
                accidental = Accidentals.SHARP;
                break;
            case doublesharp:
                accidental = Accidentals.DOUBLE_SHARP;
                break;
            case natural:
                accidental = Accidentals.NATURAL; //el becuadro no funciona ATENCION
                break;
            default:
                transduction.setZeroProbability();
                break;
        }

    }

    public Accidentals getAccidental() {
        return accidental;
    }

    public Long getAgnosticID() {
        return agnosticID;
    }
}
