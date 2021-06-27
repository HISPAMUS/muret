package es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton;

import es.ua.dlsi.grfia.im3ws.muret.model.transducers.IAgnostic2SemanticTransducer;
import es.ua.dlsi.grfia.im3ws.muret.model.transducers.SemanticTransduction;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.adt.Pair;
import es.ua.dlsi.im3.core.adt.dfa.NonDeterministicProbabilisticAutomaton;
import es.ua.dlsi.im3.core.adt.dfa.ProbabilisticAutomaton;
import es.ua.dlsi.im3.core.adt.dfa.State;
import es.ua.dlsi.im3.core.score.*;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticEncoding;
import es.ua.dlsi.im3.omr.encoding.agnostic.AgnosticSymbolType;
import es.ua.dlsi.im3.omr.encoding.semantic.Semantic2IMCore;
import es.ua.dlsi.im3.omr.encoding.semantic.SemanticEncoding;
import es.ua.dlsi.im3.omr.encoding.semantic.SemanticSymbol;
import es.ua.dlsi.im3.omr.encoding.semantic.semanticsymbols.SemanticNote;

import java.util.LinkedList;
import java.util.List;

public abstract class Agnostic2SemanticTransducer implements IAgnostic2SemanticTransducer {
    protected ProbabilisticAutomaton<State, AgnosticSymbolType, SemanticTransduction> ndpa;
    NotationType notationType;

    public Agnostic2SemanticTransducer(NotationType notationType) {
        this.notationType = notationType;
    }

    public SemanticTransduction transduce(AgnosticEncoding agnosticEncoding) throws IM3Exception {
        ndpa.setSkipUnknownSymbols(true);
        SemanticTransduction transduction = ndpa.probabilityOf(agnosticEncoding.getSymbols(), initialProbability -> new SemanticTransduction(initialProbability));

        // now group beams, set ties and tuplets
        BeamGroup beamGroup = null;
        SemanticNote lastNote = null;
        Integer inTuplet = null;
        for (SemanticSymbol symbol: transduction.getSemanticEncoding().getSymbols()) {
            if (symbol.getSymbol() instanceof SemanticNote) {
                SemanticNote semanticNote = (SemanticNote) symbol.getSymbol();
                if (semanticNote.getTupletNumber() != null) {
                    inTuplet = semanticNote.getTupletNumber();
                }
                if (semanticNote.getSemanticBeamType() != null) {
                    switch (semanticNote.getSemanticBeamType()) {
                        case start:
                            beamGroup = new BeamGroup(false);
                            beamGroup.add(semanticNote.getCoreSymbol());
                            break;
                        case inner:
                            if (beamGroup == null) {
                                throw new IM3Exception("Missing beam start");
                            }
                            beamGroup.add(semanticNote.getCoreSymbol());
                            break;
                        case end:
                            if (beamGroup == null) {
                                throw new IM3Exception("Missing beam start");
                            }
                            beamGroup.add(semanticNote.getCoreSymbol());

                            if (inTuplet != null) {
                                if (beamGroup.getIncludedFigures().size() == inTuplet) {
                                    for (SingleFigureAtom atom: beamGroup.getIncludedFigures()) {
                                        atom.setInTuplet(inTuplet);
                                    }
                                } else {
                                    throw new IM3Exception("Expected a beam group of " + inTuplet + " notes for tuplet and found " + beamGroup.getIncludedFigures().size());
                                }

                                inTuplet = null;
                            }
                            beamGroup = null;
                            break;
                        default:
                            throw new IM3Exception("Unknown beam type: " +  semanticNote.getSemanticBeamType());
                    }
                }

                if (lastNote != null && lastNote.isTiedToNext()) {
                    lastNote.getCoreSymbol().tieToNext(semanticNote.getCoreSymbol());
                }
                lastNote = semanticNote;
            }
        }

        return transduction;
    }

    public List<ITimedElementInStaff> semantic2IMCore(SemanticEncoding semanticEncoding, boolean addStaffSyncLine) throws IM3Exception {
        Semantic2IMCore semantic2ScoreSong = new Semantic2IMCore();
        LinkedList<ITimedElementInStaff> result = new LinkedList<>();
        List<Pair<SemanticSymbol, ITimedElementInStaff>> pairs = semantic2ScoreSong.convert(notationType, semanticEncoding, addStaffSyncLine);
        pairs.forEach(pair -> {
            result.add(pair.getY());
        });

        return result;
    }}
