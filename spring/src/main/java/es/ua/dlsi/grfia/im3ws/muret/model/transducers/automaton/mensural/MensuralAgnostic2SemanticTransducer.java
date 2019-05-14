package es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.mensural;

import es.ua.dlsi.grfia.im3ws.muret.model.transducers.Agnostic2SemanticTransducer;
import es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.SemanticTransduction;
import es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.mensural.states.*;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.adt.dfa.*;
import es.ua.dlsi.im3.core.score.*;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticEncoding;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticSymbolType;
import es.ua.dlsi.im3.omr.encoding.agnostic.agnosticsymbols.*;
import es.ua.dlsi.im3.omr.encoding.agnostic.agnosticsymbols.Clef;
import es.ua.dlsi.im3.omr.encoding.agnostic.agnosticsymbols.Custos;
import es.ua.dlsi.im3.omr.encoding.semantic.Semantic2IMCore;
import es.ua.dlsi.im3.omr.encoding.semantic.SemanticEncoding;
import es.ua.dlsi.im3.omr.language.GraphicalSymbolAlphabet;
import es.ua.dlsi.im3.omr.language.mensural.BarLineState;
import org.apache.commons.math3.fraction.BigFraction;
import org.apache.commons.math3.fraction.Fraction;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * See previous implementations in es.ua.dlsi.im3.omr.language
 * We are not using them here for experimentation convenience
 */
public class MensuralAgnostic2SemanticTransducer extends Agnostic2SemanticTransducer {

    public MensuralAgnostic2SemanticTransducer() throws IM3Exception, FileNotFoundException {
        HashSet<State> states = new HashSet<>();
        State start = new State(1, "start");
        State clef = new ClefState(2);
        State keysig = new KeySignatureState(3);
        State timesig = new TimeSignatureState(4);
        State noteacc = new AccNoteState(6);
        State notes = new NotesState(7, "notes");
        State custos = new CustosState(8);
        State barline = new BarLineState(9);
        states.add(start);
        states.add(clef);
        states.add(keysig);
        states.add(timesig);
        states.add(noteacc);
        states.add(notes);
        states.add(barline);
        states.add(custos);

        HashMap<State, Fraction> endStates = new HashMap<>();
        endStates.put(notes, Fraction.ONE_THIRD);
        endStates.put(custos, Fraction.ONE_THIRD);
        endStates.put(barline, Fraction.ONE_THIRD);

        HashSet<Transition<State, AgnosticSymbolType>> transitions = new HashSet<>();
        transitions.add(new Transition<>(start, new Clef(), clef));
        transitions.add(new Transition<>(clef, new Accidental(), keysig));
        transitions.add(new Transition<>(clef, new Note(), notes)); // for second systems ...
        transitions.add(new Transition<>(clef, new Rest(), notes)); // for second systems ...
        transitions.add(new Transition<>(keysig, new Accidental(), keysig));
        transitions.add(new Transition<>(clef, new MeterSign(), timesig));
        transitions.add(new Transition<>(keysig, new MeterSign(), timesig));
        transitions.add(new Transition<>(timesig, new Rest(), notes));
        transitions.add(new Transition<>(timesig, new Accidental(), noteacc));
        transitions.add(new Transition<>(timesig, new Note(), notes));

        transitions.add(new Transition<>(notes, new Accidental(), noteacc));
        transitions.add(new Transition<>(barline, new Accidental(), noteacc));

        transitions.add(new Transition<>(notes, new Rest(), notes));
        transitions.add(new Transition<>(notes, new Note(), notes));
        transitions.add(new Transition<>(notes, new Dot(), notes));
        transitions.add(new Transition<>(notes, new Custos(), custos));
        transitions.add(new Transition<>(barline, new Note(), notes));
        transitions.add(new Transition<>(barline, new Rest(), notes));
        transitions.add(new Transition<>(noteacc, new Note(), notes));
        transitions.add(new Transition<>(notes, new VerticalLine(), barline));

        //TODO Añadir defect en todo

        GraphicalSymbolAlphabet alphabet = new GraphicalSymbolAlphabet();
        dpa = new DeterministicProbabilisticAutomaton(states, start,endStates, alphabet, transitions);
        dpa.setDebug(true);
        dpa.normalizeProbabilities();

        System.err.println("TO-DO Quitar escritura DOT");
        dpa.writeDot(new File("/tmp/dpamensural.dot"));

    }

    @Override
    public SemanticTransduction transduce(AgnosticEncoding agnosticEncoding) throws IM3Exception {
        SemanticTransduction transduction = dpa.probabilityOf(agnosticEncoding.getSymbols(), new ITransductionFactory<SemanticTransduction>() {
            @Override
            public SemanticTransduction create(BigFraction initialProbability) throws IM3Exception {
                return new SemanticTransduction(initialProbability);
            }
        });
        return transduction;
    }

    @Override
    public List<ITimedElementInStaff> semantic2IMCore(TimeSignature lastTimeSignature, KeySignature lastKeySignature, SemanticEncoding semanticEncoding) throws IM3Exception {
        Semantic2IMCore semantic2ScoreSong = new Semantic2IMCore();
        return semantic2ScoreSong.convert(NotationType.eMensural, lastTimeSignature, lastKeySignature, semanticEncoding);
    }
}
