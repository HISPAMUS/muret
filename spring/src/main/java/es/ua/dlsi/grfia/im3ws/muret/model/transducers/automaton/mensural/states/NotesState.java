package es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.mensural.states;

import es.ua.dlsi.grfia.im3ws.muret.model.transducers.automaton.common.CommonNotesState;
import es.ua.dlsi.im3.core.IM3Exception;
import es.ua.dlsi.im3.core.IM3RuntimeException;
import es.ua.dlsi.im3.core.io.ImportException;
import es.ua.dlsi.im3.core.score.*;
import es.ua.dlsi.im3.core.score.mensural.meters.Perfection;
import es.ua.dlsi.im3.core.score.mensural.meters.TimeSignatureMensural;
import es.ua.dlsi.im3.core.score.mensural.meters.hispanic.TimeSignatureProporcionMayor;
import es.ua.dlsi.im3.core.score.mensural.meters.hispanic.TimeSignatureProporcionMenor;
import es.ua.dlsi.im3.core.score.meters.TimeSignatureCommonTime;
import es.ua.dlsi.im3.core.score.meters.TimeSignatureCutTime;
import es.ua.dlsi.im3.omr.encoding.agnostic.agnosticsymbols.NoteFigures;
import es.ua.dlsi.im3.omr.encoding.agnostic.agnosticsymbols.RestFigures;
import es.ua.dlsi.im3.omr.encoding.semantic.semanticsymbols.SemanticKeySignature;
import es.ua.dlsi.im3.omr.encoding.semantic.semanticsymbols.SemanticTimeSignature;


// TODO: 5/10/17 Mirar si podemos compartir algo con modern
public class NotesState extends CommonNotesState {
    private boolean inTernaryRhythm;

    public NotesState(int number) {
        super(number, NotationType.eMensural);
    }

    @Override
    protected void postProcessContext(SemanticKeySignature semanticKeySignature, SemanticTimeSignature semanticTimeSignature) throws IM3Exception {
        inTernaryRhythm = computeInTernaryRhythm(semanticTimeSignature);
    }

    //TODO Mejor en IMCore
    // TODO añadir contexto (pentagrama anterior)
    private boolean computeInTernaryRhythm(SemanticTimeSignature semanticTimeSignature) throws ImportException {
        if (semanticTimeSignature == null) {
            System.err.println("TO-DO compás pentagrama anterior");
            return false;
        }
        TimeSignature ts = (TimeSignature) semanticTimeSignature.getCoreSymbol();
        if (ts instanceof TimeSignatureCommonTime || ts instanceof TimeSignatureCutTime) {
            return false;
        } else if (ts instanceof TimeSignatureProporcionMayor || ts instanceof TimeSignatureProporcionMenor) {
            return true;
        } else if (ts instanceof TimeSignatureMensural) {
            return ((TimeSignatureMensural)ts).getProlatio() == Perfection.perfectum;
        } else {
            throw new ImportException("Unsupported meter type:  " + ts.getClass());
        }
    }


    //TODO Esto es solo para compases binarios
    protected FiguresColoration convert(NoteFigures value) {
        switch (value) {
            case doubleWholeBlackStem:
                return new FiguresColoration(Figures.MAXIMA, true);
            case tripleWholeStem:
                return new FiguresColoration(Figures.MAXIMA, true);
            case doubleWholeStem:
                return new FiguresColoration(Figures.MAXIMA, true);
            case doubleWhole:
                return new FiguresColoration(Figures.MAXIMA, true);
            case quadrupleWholeStem:
                return new FiguresColoration(Figures.MAXIMA, true);
            case longa:
                return new FiguresColoration(Figures.LONGA, null);
            case breveBlack:
                return new FiguresColoration(Figures.BREVE, true);
            case breve:
                return new FiguresColoration(Figures.BREVE, false);
            case whole:
                return new FiguresColoration(Figures.SEMIBREVE, false);
            case wholeBlack:
                return new FiguresColoration(Figures.SEMIBREVE, true);
            case half:
                if (inTernaryRhythm) {
                    return new FiguresColoration(Figures.SEMIMINIM, true);
                } else {
                    return new FiguresColoration(Figures.MINIM, null);
                }
            case quarter:
                if (inTernaryRhythm) {
                    return new FiguresColoration(Figures.MINIM, true);
                } else {
                    return new FiguresColoration(Figures.SEMIMINIM, null);
                }
            case eighthVoid:
                return new FiguresColoration(Figures.SEMIMINIM, null);
            case eighth:
                return new FiguresColoration(Figures.FUSA, null);
            case eighthCut:
                return new FiguresColoration(Figures.SEMIFUSA, null);
            default:
                throw new IM3RuntimeException("Unsupported figure " + value);
        }
    }


    //TODO Esto es solo para compases binarios
    protected Figures convert(RestFigures value) {
        switch (value) {
            case fusa:
            case eighth:
                return Figures.FUSA;
            case breve:
                return Figures.BREVE;
            case half:
                return Figures.MINIM;
            case longa2:
                return Figures.LONGA;
            case quarter:
            case seminima:
                return Figures.SEMIMINIM;
            case whole:
                return Figures.SEMIBREVE;
            default:
                throw new IM3RuntimeException("Unsupported figure " + value);
        }
    }



}

