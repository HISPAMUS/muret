package es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.mensural.states;

import es.ua.dlsi.grfia.im3ws.muret.model.transducers.SemanticTransduction;
import es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.TransducerState;
import es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.common.AccNoteState;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.adt.dfa.State;
import es.ua.dlsi.im3.core.score.Accidentals;
import es.ua.dlsi.im3.core.score.Custos;
import es.ua.dlsi.im3.core.score.ScientificPitch;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticSymbol;
import es.ua.dlsi.im3.omr.encoding.semantic.semanticsymbols.SemanticClef;
import es.ua.dlsi.im3.omr.encoding.semantic.semanticsymbols.SemanticCustos;

import java.util.ArrayList;

public class CustosState extends TransducerState {
    private Accidentals accidental;

    public CustosState(int number) {
        super(number, "custos");
    }

    @Override
    public void onEnter(AgnosticSymbol token, State previousState, SemanticTransduction transduction) throws IM3Exception {
        ArrayList<Long> agnosticIDs = new ArrayList<>();

        if (previousState instanceof AccNoteState) {
            AccNoteState prevState = (AccNoteState) previousState;
            accidental = prevState.getAccidental(); //Ojo, si en el mismo compas hay otra nota alterada no lo ve
            agnosticIDs.add(prevState.getAgnosticID());
        }

        agnosticIDs.add(token.getId());

        SemanticClef clef = NotesState.findLastClef(transduction);

        ScientificPitch scientificPitch = NotesState.parsePitch(clef, token.getPositionInStaff(), accidental);

        Custos custos = new Custos(scientificPitch);
        SemanticCustos semanticCustos = new SemanticCustos(custos);
        semanticCustos.setAgnosticIDs(agnosticIDs);
        transduction.add(semanticCustos);
    }
}

