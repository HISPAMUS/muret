package es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.mensural;

import es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.Agnostic2SemanticTransducer;
import es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.common.AccNoteState;
import es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.mensural.states.ClefState;
import es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.mensural.states.TimeSignatureState;
import es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.mensural.states.*;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.adt.dfa.*;
import es.ua.dlsi.im3.core.score.*;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticSymbolType;
import es.ua.dlsi.im3.omr.encoding.agnostic.agnosticsymbols.*;
import es.ua.dlsi.im3.omr.encoding.agnostic.agnosticsymbols.Clef;
import es.ua.dlsi.im3.omr.encoding.agnostic.agnosticsymbols.Custos;
import es.ua.dlsi.im3.omr.encoding.agnostic.agnosticsymbols.Fermata;
import es.ua.dlsi.im3.omr.language.GraphicalSymbolAlphabet;
import es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.common.FermataState;
import org.apache.commons.math3.fraction.Fraction;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;

/**
 * See previous implementations in es.ua.dlsi.im3.omr.language
 * We are not using them here for experimentation convenience
 */
public class MensuralAgnostic2SemanticTransducer extends Agnostic2SemanticTransducer {

    public MensuralAgnostic2SemanticTransducer() throws IM3Exception, FileNotFoundException {
        super(NotationType.eMensural);
        HashSet<State> states = new HashSet<>();
        State start = new State(1, "start");
        State clef = new ClefState(2);
        State keysig = new KeySignatureState(3);
        State timesig = new TimeSignatureState(4);
        State noteacc = new AccNoteState(6);
        State notes = new NotesState(7);
        State custos = new CustosState(8);
        State barline = new BarLineState(9);
        State fermata = new FermataState(10);
        states.add(start);
        states.add(clef);
        states.add(keysig);
        states.add(timesig);
        states.add(noteacc);
        states.add(notes);
        states.add(barline);
        states.add(custos);
        states.add(fermata);

        HashMap<State, Fraction> endStates = new HashMap<>();
        endStates.put(notes, Fraction.ONE_THIRD);
        endStates.put(custos, Fraction.ONE_THIRD);
        endStates.put(barline, Fraction.ONE_THIRD);

        HashSet<Transition<State, AgnosticSymbolType>> transitions = new HashSet<>();
        transitions.add(new Transition<>(start, new Clef(), clef));

        transitions.add(new Transition<>(clef, new Accidental(), keysig));
        transitions.add(new Transition<>(clef, new Note(), notes)); // for second systems ...
        transitions.add(new Transition<>(clef, new Rest(), notes)); // for second systems ...
        transitions.add(new Transition<>(clef, new es.ua.dlsi.im3.omr.encoding.agnostic.agnosticsymbols.Ligature(), notes));
        transitions.add(new Transition<>(clef, new MeterSign(), timesig));
        transitions.add(new Transition<>(clef, new Fermata(), fermata));


        transitions.add(new Transition<>(keysig, new Accidental(), keysig));
        transitions.add(new Transition<>(keysig, new MeterSign(), timesig));
        transitions.add(new Transition<>(keysig, new Fermata(), fermata));

        transitions.add(new Transition<>(keysig, new Note(), notes)); //TODO no está esto bien del todo.. ver 2º 7 3º pentagrama RISM
        transitions.add(new Transition<>(keysig, new Rest(), notes)); //TODO no está esto bien del todo.. ver 2º 7 3º pentagrama RISM
        transitions.add(new Transition<>(keysig, new es.ua.dlsi.im3.omr.encoding.agnostic.agnosticsymbols.Ligature(), notes));

        transitions.add(new Transition<>(timesig, new Accidental(), noteacc));
        transitions.add(new Transition<>(fermata, new Accidental(), noteacc));
        transitions.add(new Transition<>(fermata, new Note(), notes));

        transitions.add(new Transition<>(timesig, new Note(), notes));
        transitions.add(new Transition<>(timesig, new Rest(), notes));
        transitions.add(new Transition<>(timesig, new es.ua.dlsi.im3.omr.encoding.agnostic.agnosticsymbols.Ligature(), notes));
        transitions.add(new Transition<>(timesig, new Fermata(), fermata));

        transitions.add(new Transition<>(notes, new Accidental(), noteacc));
        transitions.add(new Transition<>(barline, new Accidental(), noteacc));
        transitions.add(new Transition<>(barline, new Clef(), clef));
        transitions.add(new Transition<>(barline, new Fermata(), fermata));

        transitions.add(new Transition<>(notes, new Note(), notes));
        transitions.add(new Transition<>(notes, new Dot(), notes));
        transitions.add(new Transition<>(notes, new Fermata(), fermata));
        transitions.add(new Transition<>(notes, new Rest(), notes));
        transitions.add(new Transition<>(notes, new es.ua.dlsi.im3.omr.encoding.agnostic.agnosticsymbols.Ligature(), notes));
        transitions.add(new Transition<>(notes, new Custos(), custos));
        transitions.add(new Transition<>(notes, new MeterSign(), timesig));
        transitions.add(new Transition<>(barline, new MeterSign(), timesig));
        transitions.add(new Transition<>(barline, new Note(), notes));
        transitions.add(new Transition<>(barline, new Rest(), notes));
        transitions.add(new Transition<>(barline, new es.ua.dlsi.im3.omr.encoding.agnostic.agnosticsymbols.Ligature(), notes));
        transitions.add(new Transition<>(noteacc, new Note(), notes));
        transitions.add(new Transition<>(noteacc, new Custos(), custos));
        transitions.add(new Transition<>(noteacc, new Fermata(), fermata));
        transitions.add(new Transition<>(notes, new VerticalLine(), barline));
        transitions.add(new Transition<>(barline, new VerticalLine(), barline));

        //TODO Añadir defect en todo

        GraphicalSymbolAlphabet alphabet = new GraphicalSymbolAlphabet();
        dpa = new DeterministicProbabilisticAutomaton(states, start,endStates, alphabet, transitions);
        dpa.setDebug(true);
        dpa.normalizeProbabilities();

        System.err.println("TO-DO Quitar escritura DOT");
        dpa.writeDot(new File("/tmp/dpamensural.dot"));

    }
}
