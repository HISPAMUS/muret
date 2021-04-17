package es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.modern;

import es.ua.dlsi.grfia.im3ws.muret.model.transducers.SemanticTransduction;
import es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.Agnostic2SemanticTransducer;
import es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.common.AccNoteState;
import es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.modern.states.*;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.adt.dfa.*;
import es.ua.dlsi.im3.core.score.*;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticSymbolType;
import es.ua.dlsi.im3.omr.encoding.agnostic.agnosticsymbols.*;
import es.ua.dlsi.im3.omr.encoding.agnostic.agnosticsymbols.Clef;
import es.ua.dlsi.im3.omr.encoding.agnostic.agnosticsymbols.Slur;
import es.ua.dlsi.im3.omr.language.GraphicalSymbolAlphabet;
import org.apache.commons.math3.fraction.Fraction;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author David Rizo
 */
public class ModernAgnostic2SemanticTransducer extends Agnostic2SemanticTransducer {
    public ModernAgnostic2SemanticTransducer() throws IM3Exception, FileNotFoundException {
        super(NotationType.eModern);

        HashSet<State> states = new HashSet<>();
        State start = new State(1, "start");
        State clef = new ClefState(2);
        State keysig = new KeySignatureState(3);
        State timesig = new TimeSignatureState(4);
        State noteacc = new AccNoteState(6);
        State notes = new NotesState(7);
        State barline = new BarLineState(9);
        State multirest = new MultirestState(10);
        states.add(start);
        states.add(clef);
        states.add(keysig);
        states.add(timesig);
        states.add(noteacc);
        states.add(notes);
        states.add(barline);
        states.add(multirest);

        HashMap<State, Fraction> endStates = new HashMap<>();
        endStates.put(notes, Fraction.TWO_THIRDS);
        endStates.put(barline, Fraction.TWO_THIRDS);

        HashSet<Transition<State, AgnosticSymbolType>> transitions = new HashSet<>();
        transitions.add(new Transition<>(start, new Clef(), clef));

        transitions.add(new Transition<>(clef, new Accidental(), keysig));
        transitions.add(new Transition<>(clef, new Note(), notes)); // for second systems ...
        transitions.add(new Transition<>(clef, new Appoggiatura(), notes));
        transitions.add(new Transition<>(clef, new Acciaccatura(), notes));
        transitions.add(new Transition<>(clef, new Rest(), notes)); // for second systems ...
        transitions.add(new Transition<>(clef, new es.ua.dlsi.im3.omr.encoding.agnostic.agnosticsymbols.Ligature(), notes));
        transitions.add(new Transition<>(clef, new MeterSign(), timesig));

        transitions.add(new Transition<>(keysig, new Accidental(), keysig));
        transitions.add(new Transition<>(keysig, new MeterSign(), timesig));

        transitions.add(new Transition<>(keysig, new Note(), notes)); //TODO no está esto bien del todo.. ver 2º 7 3º pentagrama RISM
        transitions.add(new Transition<>(keysig, new Rest(), notes)); //TODO no está esto bien del todo.. ver 2º 7 3º pentagrama RISM
        transitions.add(new Transition<>(keysig, new Appoggiatura(), notes));
        transitions.add(new Transition<>(keysig, new Acciaccatura(), notes));
        transitions.add(new Transition<>(keysig, new es.ua.dlsi.im3.omr.encoding.agnostic.agnosticsymbols.Ligature(), notes));

        // transitions.add(new Transition<>(timesig, new VerticalSeparator(), timesig));
        transitions.add(new Transition<>(keysig, new Digit(), timesig));
        transitions.add(new Transition<>(barline, new Digit(), timesig));
        transitions.add(new Transition<>(clef, new Digit(), timesig));
        transitions.add(new Transition<>(timesig, new Digit(), timesig));
        transitions.add(new Transition<>(timesig, new Accidental(), noteacc));
        transitions.add(new Transition<>(timesig, new Note(), notes));
        transitions.add(new Transition<>(timesig, new Appoggiatura(), notes));
        transitions.add(new Transition<>(timesig, new Acciaccatura(), notes));
        transitions.add(new Transition<>(timesig, new Rest(), notes));
        transitions.add(new Transition<>(timesig, new es.ua.dlsi.im3.omr.encoding.agnostic.agnosticsymbols.Ligature(), notes));

        transitions.add(new Transition<>(timesig, new Multirest(), multirest));
        //transitions.add(new Transition<>(timesig, new Digit(), multirest));
        transitions.add(new Transition<>(clef, new Multirest(), multirest));
        transitions.add(new Transition<>(multirest, new Digit(), multirest));
        transitions.add(new Transition<>(barline, new Multirest(), multirest));
        transitions.add(new Transition<>(keysig, new Multirest(), multirest));

        transitions.add(new Transition<>(multirest, new Accidental(), noteacc));
        transitions.add(new Transition<>(multirest, new Note(), notes));
        transitions.add(new Transition<>(multirest, new Appoggiatura(), notes));
        transitions.add(new Transition<>(multirest, new Acciaccatura(), notes));
        transitions.add(new Transition<>(multirest, new Rest(), notes));
        transitions.add(new Transition<>(multirest, new VerticalLine(), barline));

        transitions.add(new Transition<>(notes, new Accidental(), noteacc));
        transitions.add(new Transition<>(barline, new Accidental(), noteacc));
        transitions.add(new Transition<>(barline, new Clef(), clef));

        transitions.add(new Transition<>(notes, new Note(), notes));
        transitions.add(new Transition<>(notes, new Digit(), notes)); // for tuplets
        transitions.add(new Transition<>(notes, new Appoggiatura(), notes));
        transitions.add(new Transition<>(notes, new Acciaccatura(), notes));
        transitions.add(new Transition<>(notes, new Dot(), notes));
        transitions.add(new Transition<>(notes, new Rest(), notes));
        transitions.add(new Transition<>(notes, new Slur(), notes));
        transitions.add(new Transition<>(notes, new es.ua.dlsi.im3.omr.encoding.agnostic.agnosticsymbols.Ligature(), notes));
        transitions.add(new Transition<>(barline, new Note(), notes));
        transitions.add(new Transition<>(barline, new Appoggiatura(), notes));
        transitions.add(new Transition<>(barline, new Acciaccatura(), notes));
        transitions.add(new Transition<>(barline, new Rest(), notes));
        transitions.add(new Transition<>(barline, new es.ua.dlsi.im3.omr.encoding.agnostic.agnosticsymbols.Ligature(), notes));
        transitions.add(new Transition<>(noteacc, new Note(), notes));
        transitions.add(new Transition<>(noteacc, new Appoggiatura(), notes));
        transitions.add(new Transition<>(noteacc, new Acciaccatura(), notes));
        transitions.add(new Transition<>(notes, new VerticalLine(), barline));
        transitions.add(new Transition<>(barline, new VerticalLine(), barline));



        //TODO Añadir defect en todo

        GraphicalSymbolAlphabet alphabet = new GraphicalSymbolAlphabet();
        dpa = new DeterministicProbabilisticAutomaton(states, start,endStates, alphabet, transitions);
        dpa.setDebug(true);
        dpa.normalizeProbabilities();

        System.err.println("TO-DO Quitar escritura DOT");
        dpa.writeDot(new File("/tmp/dpamodern.dot"));
        dpa.writeDot(new File("/tmp/dpamodern.dot"));
    }

}
