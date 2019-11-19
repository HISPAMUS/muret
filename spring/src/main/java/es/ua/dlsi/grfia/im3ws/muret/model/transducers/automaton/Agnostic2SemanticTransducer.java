package es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton;

import es.ua.dlsi.grfia.im3ws.muret.model.transducers.IAgnostic2SemanticTransducer;
import es.ua.dlsi.grfia.im3ws.muret.model.transducers.SemanticTransduction;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.adt.Pair;
import es.ua.dlsi.im3.core.adt.dfa.DeterministicProbabilisticAutomaton;
import es.ua.dlsi.im3.core.adt.dfa.State;
import es.ua.dlsi.im3.core.score.ITimedElementInStaff;
import es.ua.dlsi.im3.core.score.KeySignature;
import es.ua.dlsi.im3.core.score.NotationType;
import es.ua.dlsi.im3.core.score.TimeSignature;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticEncoding;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticSymbolType;
import es.ua.dlsi.im3.omr.encoding.semantic.Semantic2IMCore;
import es.ua.dlsi.im3.omr.encoding.semantic.SemanticEncoding;
import es.ua.dlsi.im3.omr.encoding.semantic.SemanticSymbol;

import java.util.LinkedList;
import java.util.List;

public abstract class Agnostic2SemanticTransducer implements IAgnostic2SemanticTransducer {
    protected DeterministicProbabilisticAutomaton<State, AgnosticSymbolType, SemanticTransduction> dpa;
    NotationType notationType;

    public Agnostic2SemanticTransducer(NotationType notationType) {
        this.notationType = notationType;
    }

    public SemanticTransduction transduce(AgnosticEncoding agnosticEncoding) throws IM3Exception {
        SemanticTransduction transduction = dpa.probabilityOf(agnosticEncoding.getSymbols(), initialProbability -> new SemanticTransduction(initialProbability));
        return transduction;
    }

    public List<ITimedElementInStaff> semantic2IMCore(TimeSignature lastTimeSignature, KeySignature lastKeySignature, SemanticEncoding semanticEncoding) throws IM3Exception {
        Semantic2IMCore semantic2ScoreSong = new Semantic2IMCore();
        LinkedList<ITimedElementInStaff> result = new LinkedList<>();
        List<Pair<SemanticSymbol, ITimedElementInStaff>> pairs = semantic2ScoreSong.convert(notationType, lastTimeSignature, lastKeySignature, semanticEncoding);
        pairs.forEach(pair -> {
            result.add(pair.getY());
        });

        return result;
    }}
