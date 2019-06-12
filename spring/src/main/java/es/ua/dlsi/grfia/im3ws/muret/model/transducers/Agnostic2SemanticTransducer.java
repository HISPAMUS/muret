package es.ua.dlsi.grfia.im3ws.muret.model.transducers;

import es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.SemanticTransduction;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.adt.dfa.DeterministicProbabilisticAutomaton;
import es.ua.dlsi.im3.core.adt.dfa.State;
import es.ua.dlsi.im3.core.score.ITimedElementInStaff;
import es.ua.dlsi.im3.core.score.KeySignature;
import es.ua.dlsi.im3.core.score.NotationType;
import es.ua.dlsi.im3.core.score.TimeSignature;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticEncoding;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticSymbolType;
import es.ua.dlsi.im3.omr.encoding.semantic.SemanticEncoding;

import java.util.List;

public abstract class Agnostic2SemanticTransducer {
    protected DeterministicProbabilisticAutomaton<State, AgnosticSymbolType, SemanticTransduction> dpa;

    public abstract SemanticTransduction transduce(AgnosticEncoding agnosticEncoding) throws IM3Exception;
    public abstract List<ITimedElementInStaff> semantic2IMCore(TimeSignature lastTimeSignature, KeySignature lastKeySignature, SemanticEncoding semanticEncoding) throws IM3Exception;
}
